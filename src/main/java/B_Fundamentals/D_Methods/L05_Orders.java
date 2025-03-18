package B_Fundamentals.D_Methods;

import java.util.*;

public class L05_Orders {

/*Write a method that calculates the total price of an order and prints it on the console.
The method should receive one of the following products: coffee, water, coke, snacks, and a quantity of the product.

The prices for a single piece of each product are:
    •	"coffee" – 1.50
    •	"water" – 1.00
    •	"coke" – 1.40
    •	"snacks" – 2.00
Print the result rounded to the second decimal place.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double productPrice = switch (product) {
            case "coffee" -> 1.50;
            case "water" -> 1.00;
            case "coke" -> 1.40;
            case "snacks" -> 2.00;
            default -> 0;
        };
        printOrderTotal(quantity, productPrice);
    }

    private static void printOrderTotal(int quantity, double productPrice) {
        System.out.printf("%.2f", quantity * productPrice);
    }
}
