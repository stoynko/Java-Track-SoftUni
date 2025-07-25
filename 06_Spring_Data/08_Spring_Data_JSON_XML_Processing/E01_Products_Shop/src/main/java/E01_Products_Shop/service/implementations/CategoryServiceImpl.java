package E01_Products_Shop.service.implementations;

import E01_Products_Shop.data.*;
import E01_Products_Shop.data.dtos.*;
import E01_Products_Shop.repositories.*;
import E01_Products_Shop.repositories.projections.*;
import E01_Products_Shop.service.*;
import E01_Products_Shop.service.utilities.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.*;
import com.google.gson.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_JSON_PATH_JACKSON = "json/imports/categories.json";
    private static final String CATEGORIES_JSON_PATH_GSON = "06_Spring_Data/08_Spring_Data_JSON_Processing/E01_Products_Shop/src/main/resources/json/categories.json";

    private final CategoryRepository categoriesRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;
    private final ValidatorUtility validator;
    private final Gson gson;
    private final ExportUtility exporter;
    private final XmlMapper xmlMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoriesRepository, ModelMapper modelMapper, ObjectMapper objectMapper, ValidatorUtility validator, Gson gson, ExportUtility exporter, XmlMapper xmlMapper) {
        this.categoriesRepository = categoriesRepository;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
        this.validator = validator;
        this.gson = gson;
        this.exporter = exporter;
        this.xmlMapper = xmlMapper;
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> randomCategories = new HashSet<>();
        int randomCategoriesCount = ThreadLocalRandom.current().nextInt(1, 4);

        while (randomCategories.size() != randomCategoriesCount) {
            long randomId = ThreadLocalRandom.current().nextLong(1, this.categoriesRepository.count() + 1);
            Category category = categoriesRepository.findById(randomId).get();
            if (!randomCategories.contains(category)) {
                randomCategories.add(category);
            }
        }
        return randomCategories;
    }

    @Override
    public void importDataWithJackson() {
        try {
            InputStream inputStream = new ClassPathResource(CATEGORIES_JSON_PATH_JACKSON).getInputStream();
            Set<ImportCategoryDTO> categories = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
            for (ImportCategoryDTO categoryDTO : categories) {
                if (!validator.isValid(categoryDTO)) {
                    System.out.println(validator.getViolations(categoryDTO));
                    continue;
                }
                categoriesRepository.saveAndFlush(modelMapper.map(categoryDTO, Category.class));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load or parse JSON file with path: " + CATEGORIES_JSON_PATH_JACKSON, e);
        }
    }

    @Override
    public void importDataWithGSON() {
        try {
            String inputData = String.join("", Files.readAllLines(Path.of(CATEGORIES_JSON_PATH_GSON)));
            ImportCategoryDTO[] inputCategories = gson.fromJson(inputData, ImportCategoryDTO[].class);
            for (ImportCategoryDTO categoryDTO : inputCategories) {
                if (!validator.isValid(categoryDTO)) {
                    System.out.println(validator.getViolations(categoryDTO));
                    continue;
                }
                categoriesRepository.saveAndFlush(modelMapper.map(categoryDTO, Category.class));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load or parse JSON file with path: " + CATEGORIES_JSON_PATH_GSON, e);
        }
    }

    @Override
    public boolean isImported() {
        return categoriesRepository.count() > 0;
    }

    @Override
    public void exportCategoriesInfo() {
        List<CategoryInfoProjection> categoriesInfoProjection = categoriesRepository.getCategoriesInfo();

        List<ExportCategoryInfoDTO> categories = categoriesInfoProjection.stream().map(categoryProjection -> {
            ExportCategoryInfoDTO categoryDTO = modelMapper.map(categoryProjection, ExportCategoryInfoDTO.class);
            return categoryDTO;
        }).toList();

        exporter.exportJSONCollectionWithJackson(categories, "categories-info-jackson");
        exporter.exportJSONCollectionWithGson(categories, "categories-info-gson");
    }
}