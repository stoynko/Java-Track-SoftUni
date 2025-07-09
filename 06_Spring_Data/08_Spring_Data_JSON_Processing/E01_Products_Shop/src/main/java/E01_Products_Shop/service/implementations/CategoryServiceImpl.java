package E01_Products_Shop.service.implementations;

import E01_Products_Shop.data.*;
import E01_Products_Shop.repositories.*;
import E01_Products_Shop.service.*;
import E01_Products_Shop.service.dtos.*;
import E01_Products_Shop.service.utilities.*;
import com.fasterxml.jackson.core.exc.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;

import java.io.*;
import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static CategoryRepository categoriesRepository;
    private static ModelMapper modelMapper;
    private static ObjectMapper objectMapper;
    private static final String CATEGORIES_JSON_PATH = "json/categories.json";
    private final ValidatorUtil validatorUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoriesRepository, ModelMapper modelMapper, ObjectMapper objectMapper, ValidatorUtil validatorUtil) {
        this.categoriesRepository = categoriesRepository;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public void importData() {
        try {
            InputStream inputStream = new ClassPathResource(CATEGORIES_JSON_PATH).getInputStream();
            Set<ImportCategoryDTO> categories = objectMapper.readValue(inputStream, new TypeReference<Set<ImportCategoryDTO>>() {});
            for (ImportCategoryDTO categoryDTO : categories) {
                if (!validatorUtil.isValid(categoryDTO)) {
                    System.out.println(validatorUtil.getViolations(categoryDTO));
                    continue;
                }
             categoriesRepository.saveAndFlush(modelMapper.map(categoryDTO, Category.class));
            }
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load or parse JSON file: " + CATEGORIES_JSON_PATH, ex);
        }
    }
}