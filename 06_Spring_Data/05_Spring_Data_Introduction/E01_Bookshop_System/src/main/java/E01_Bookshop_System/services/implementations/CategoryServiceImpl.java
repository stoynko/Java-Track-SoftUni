package E01_Bookshop_System.services.implementations;


import E01_Bookshop_System.entities.*;
import E01_Bookshop_System.repositories.*;
import E01_Bookshop_System.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_FILE_PATH = "06_Spring_Data/05_Spring_Data_Introduction/E01_Bookshop_System/src/main/resources/files/categories.txt";
    private final CategoryRepository categoriesRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public Set<Category> getRandomCategories() {
        //TODO
        return null;
    }

    @Override
    public boolean areCategoriesImported() {
        return categoriesRepository.count() > 0;
    }

    @Override
    public void seedCategories() throws IOException {
        Files.readAllLines(Path.of(CATEGORIES_FILE_PATH)).forEach(line -> {
            String formattedLine = line.trim();
            if (!formattedLine.isBlank()) {
                Category category = new Category(formattedLine);
                this.categoriesRepository.saveAndFlush(category);
            }
        });
    }
}
