package E01_Bookshop_System.controllers;

import E01_Bookshop_System.services.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private BookServiceImpl bookService;
    private final CategoryServiceImpl categoryService;

    public ConsoleRunner(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();
    }
}
