package E01_Products_Shop.controllers;

import E01_Products_Shop.service.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class CommandRunner implements CommandLineRunner {

    private CategoryService categoryService;
    private UserService userService;
    private ProductService productService;

    public CommandRunner(CategoryService categoryService, UserService userService, ProductService productService) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!this.categoryService.isImported()) {
            categoryService.importDataWithJackson();
            //categoryService.importDataWithGSON();
        }

        if (!this.userService.isImported()) {
            userService.importDataWithJackson();
            //userService.importDataWithGSON();
        }

        if (!this.productService.isImported()) {
            //productService.importDataWithJackson();
            productService.importDataWithGSON();
        }

    }
}
