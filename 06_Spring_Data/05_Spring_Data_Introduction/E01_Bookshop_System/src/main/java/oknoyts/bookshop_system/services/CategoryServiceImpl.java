package oknoyts.bookshop_system.services;

import oknoyts.bookshop_system.entities.*;
import oknoyts.bookshop_system.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_STRING_PATH = "files/categories.txt";
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        Set<Category> categories  = new HashSet<>();

        Files.readAllLines(Path.of(CATEGORIES_STRING_PATH))
                .forEach(line -> {
                   Category category = new Category();
                   categories.add(category);
                });
        this.categoryRepository.saveAll(categories);
    }
}
