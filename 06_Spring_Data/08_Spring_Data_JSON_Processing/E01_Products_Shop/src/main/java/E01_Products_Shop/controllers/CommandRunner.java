package E01_Products_Shop.controllers;

import E01_Products_Shop.service.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class CommandRunner implements CommandLineRunner {

    private CategoryService categoryService;

    public CommandRunner(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        categoryService.importData();
    }
}
