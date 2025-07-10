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

/*A products shop holds users, products and categories for the products. Users can sell and buy products.
    •	Users have an id, first name (optional) and last name (at least 3 characters) and age (optional).
    •	Products have an id, name (at least 3 characters), price, buyerId (optional) and sellerId as IDs of users.
    •	Categories have an id and name (from 3 to 15 characters)

Using Code First approach create a database following the above description.

Configure the following relations in your models:
    •	Users should have many products sold and many products bought.
    •	Products should have many categories.
    •	Categories should have many products.
    •	Users should have many friends (i.e. users).

2.	Seed the Database
Import the data from the provided files (users.json, products.json, categories.json).
Import the users first. When importing the products, randomly select the buyer and seller from the existing users.
Leave out some products that have not been sold (i.e. buyer is null).
Randomly generate categories for each product from the existing categories. */

    @Override
    public void run(String... args) throws Exception {

        if (!this.userService.isImported()) {
            userService.importDataWithJackson();
            //userService.importDataWithGSON();
        }

        if (!this.categoryService.isImported()) {
            categoryService.importDataWithJackson();
            //categoryService.importDataWithGSON();
        }

        if (!this.productService.isImported()) {
            //productService.importDataWithJackson();
            productService.importDataWithGSON();
        }
    }
}
