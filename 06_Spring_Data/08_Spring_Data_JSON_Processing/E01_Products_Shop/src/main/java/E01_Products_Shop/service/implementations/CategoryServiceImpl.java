package E01_Products_Shop.service.implementations;

import E01_Products_Shop.data.*;
import E01_Products_Shop.repositories.*;
import E01_Products_Shop.service.*;
import com.fasterxml.jackson.core.exc.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static CategoryRepository categoriesRepository;
    private static ModelMapper modelMapper;
    private static ObjectMapper objectMapper;
    private static final String CATEGORIES_JSON_PATH = "src/main/resources/categories.json";

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoriesRepository, ModelMapper modelMapper, ObjectMapper objectMapper) {
        this.categoriesRepository = categoriesRepository;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
    }

    @Override
    public void importData() {
        try {
            InputStream inputStream = new ClassPathResource(CATEGORIES_JSON_PATH).getInputStream();
            List<Category> categories = objectMapper.readValue(inputStream, new TypeReference<List<Category>>(){});
            System.out.println();

        } catch (IOException ex) {
            throw new RuntimeException("Failed to load or parse JSON file: " + CATEGORIES_JSON_PATH, ex);
        }
    }
}