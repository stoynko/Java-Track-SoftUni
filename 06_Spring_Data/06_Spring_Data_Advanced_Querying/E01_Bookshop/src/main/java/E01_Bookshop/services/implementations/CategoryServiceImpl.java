package E01_Bookshop.services.implementations;


import E01_Bookshop.entities.*;
import E01_Bookshop.repositories.*;
import E01_Bookshop.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_FILE_PATH = "06_Spring_Data/06_Spring_Data_Advanced_Querying/E01_Bookshop/src/main/resources/files/categories.txt";
    private final CategoryRepository categoriesRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public Set<Category> getRandomCategories() {

        Set<Category> randomCategories = new HashSet<>();
        int randomCategoriesCount = ThreadLocalRandom.current().nextInt(1, 4);

        while (randomCategories.size() != randomCategoriesCount) {
            long randomId = ThreadLocalRandom.current().nextLong(1, this.categoriesRepository.count() + 1);
            Category category = this.categoriesRepository.findById(randomId).get();
                if (!randomCategories.contains(category)) {
                    randomCategories.add(category);
                }
        }
        return randomCategories;
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
