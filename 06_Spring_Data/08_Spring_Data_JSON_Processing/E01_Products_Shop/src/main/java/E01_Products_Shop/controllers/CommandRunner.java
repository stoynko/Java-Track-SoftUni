package E01_Products_Shop.controllers;

import E01_Products_Shop.service.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class CommandRunner implements CommandLineRunner {

    private CategoryService categoryService;
    private UserService userService;

    public CommandRunner(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        //categoryService.importDataWithJackson();
        if (!categoryService.isImported()) {
            categoryService.importDataWithGSON();
        }
        userService.importDataWithGSON();
    }
}
