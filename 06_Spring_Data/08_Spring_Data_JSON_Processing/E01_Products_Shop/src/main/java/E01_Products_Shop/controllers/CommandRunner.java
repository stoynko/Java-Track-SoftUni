package E01_Products_Shop.controllers;

import E01_Products_Shop.service.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.math.*;

@Component
public class CommandRunner implements CommandLineRunner {

    private BufferedReader reader;
    private UserService userService;
    private ProductService productService;
    private CategoryService categoryService;

    public CommandRunner(BufferedReader reader, UserService userService, ProductService productService, CategoryService categoryService) {
        this.reader = reader;
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
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

        /* Get all products in a specified price range (e.g. 500 to 1000), which have no buyer. Order them by price (from lowest to highest).
           Select only the product name, price and the full name of the seller. Export the result to JSON. */
        //exportProductsInRage(reader);

        /* Get all users who have at least 1 item sold with a buyer. Order them by last name, then by first name.
        Select the person's first and last name. For each of the products sold (products with buyers), select the product's name,
        price and the buyer's first and last name. */
        exportUsersWithSoldProducts();

        /* Get all categories. Order them by the number of products in each category (a product can be in many categories).
        For each category select its name, the number of products, the average price of those products and the total revenue
        (total price sum) of those products (regardless if they have a buyer or not). */

    }

    private void exportProductsInRage(BufferedReader reader) throws IOException {
        BigDecimal lowerBound = BigDecimal.valueOf(Double.parseDouble(reader.readLine()));
        BigDecimal upperBound = BigDecimal.valueOf(Double.parseDouble(reader.readLine()));
        productService.exportProductsInRange(lowerBound, upperBound);
    }

    private void exportUsersWithSoldProducts() {
        userService.exportUsersWithSoldProducts();
    }
}