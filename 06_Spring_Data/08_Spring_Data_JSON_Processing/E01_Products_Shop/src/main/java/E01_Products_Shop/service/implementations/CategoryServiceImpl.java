package E01_Products_Shop.service.implementations;

import E01_Products_Shop.data.*;
import E01_Products_Shop.repositories.*;
import E01_Products_Shop.service.*;
import E01_Products_Shop.service.dtos.*;
import E01_Products_Shop.service.utilities.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
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

    private static final String CATEGORIES_JSON_PATH_JACKSON = "json/categories.json";
    private static final String CATEGORIES_JSON_PATH_GSON = "06_Spring_Data/08_Spring_Data_JSON_Processing/E01_Products_Shop/src/main/resources/json/categories.json";

    private static CategoryRepository categoriesRepository;
    private static ModelMapper modelMapper;
    private static ObjectMapper objectMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoriesRepository, ModelMapper modelMapper, ObjectMapper objectMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.categoriesRepository = categoriesRepository;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
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
                if (!validatorUtil.isValid(categoryDTO)) {
                    System.out.println(validatorUtil.getViolations(categoryDTO));
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
                if (!validatorUtil.isValid(categoryDTO)) {
                    System.out.println(validatorUtil.getViolations(categoryDTO));
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
}