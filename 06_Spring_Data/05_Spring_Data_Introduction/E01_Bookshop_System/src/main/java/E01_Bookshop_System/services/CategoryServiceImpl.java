package E01_Bookshop_System.services;


import E01_Bookshop_System.entities.*;
import E01_Bookshop_System.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_FILE_PATH = "06_Spring_Data/05_Spring_Data_Introduction/E01_Bookshop_System/src/main/resources/files/categories.txt";
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        Set<Category> categories  = new HashSet<>();
        Files.readAllLines(Path.of(CATEGORIES_FILE_PATH)).forEach(line -> {
            String formattedLine = line.trim();
            if (!formattedLine.isBlank()) {
                Category category = new Category(formattedLine);
                categories.add(category);
            }
        });
        this.categoryRepository.saveAll(categories);
    }
}
