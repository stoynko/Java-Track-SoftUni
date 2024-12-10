package B_Fundamentals.X_MidExam.MidExam;

import java.util.*;
import java.util.stream.*;

public class P03_GroceryShopping {

/*Jane made a list of products, which she must buy from the nearest supermarket. While completing her list, Jane checks the products in her home.
On the first line, you will receive a sequence with products, split by "|". On the following lines, until command "Shop!", you will be receiving commands.
The possible commands are:
    •	"Important%{product}":
        o	If the product exists, move it to the beginning of the list (index 0).
        o	Otherwise, add it to the list at the 0 index.
    •	"Add%{product}":
        o	If the product did not exist – add it at the end of the list.
        o	Otherwise, print: "The product is already in the list."
    •	"Swap%{product}%{product}":
        o	If both products exist – swap their places.
        o	If one of the two products is missing, print: "Product {product} missing!"
        o	There is no case in which both products are missing at the same time.
    •	"Remove%{product}":
        o	If the product is in the list, remove it.
        o	Otherwise, print: "Product {product} isn't in the list."
    •	"Reversed":
        o	Reverse the list of products.

When you receive the command "Shop!" you should print each product from the list on a new line with its number in the list (starting from 1) and end the program:
"1. {product1}
2. {product2}
N. {productN}"

Input:
    •	On the first line, you will receive a sequence with products, split by "|".
    •	On the following lines, until the command "Shop!", you will be receiving commands.
Output:
    •   Print the output needed as described above.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Shop!")) {
            String[] commands = input.split("%");
            String command = commands[0];

            switch (command) {
                case "Important" -> {
                    String product = commands[1];
                    if (shoppingList.contains(product)) {
                        shoppingList.remove(product);
                        shoppingList.add(0, product);
                    } else {
                        shoppingList.add(0, product);
                    }
                }
                case "Add" -> {
                    String product = commands[1];
                    if (!shoppingList.contains(product)) {
                        shoppingList.add(product);
                    } else {
                        System.out.println("The product is already in the list.");
                    }
                }
                case "Swap" -> {
                    String productOne = commands[1];
                    String productTwo = commands[2];
                    if (shoppingList.contains(productOne)) {
                        if (shoppingList.contains(productTwo)) {
                            int indexProductOne = shoppingList.indexOf(productOne);
                            int indexProductTwo = shoppingList.indexOf(productTwo);
                            shoppingList.set(indexProductOne, productTwo);
                            shoppingList.set(indexProductTwo, productOne);
                        } else {
                            System.out.printf("Product %s missing!%n", productTwo);
                        }
                    } else {
                        System.out.printf("Product %s missing!%n", productOne);
                    }
                }
                case "Remove" -> {
                    String product = commands[1];
                    if (shoppingList.contains(product)) {
                        shoppingList.remove(product);
                    } else {
                        System.out.printf("Product %s isn't in the list.%n", product);
                    }
                }
                case "Reversed" -> {
                    Collections.reverse(shoppingList);
                }
            }
            input = scanner.nextLine();
        }
        int counter = 1;
        for (String product : shoppingList) {
            System.out.printf("%d. %s%n", counter, product);
            counter++;
        }
    }
}