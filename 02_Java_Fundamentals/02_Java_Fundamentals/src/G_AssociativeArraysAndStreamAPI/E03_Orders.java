package G_AssociativeArraysAndStreamAPI;

import java.util.*;

public class E03_Orders {

/*Write a program which keeps the information about products and their prices. Each product has a name, a price, and its quantity. If the product doesn't exist yet,
add it with its starting quantity. If you receive a product that already exists, increases its quantity by the input quantity and if its price is different,
replace the price as well. You will receive products' names, prices, and quantities on new lines. Until you receive the command "buy", keep adding items.
When you do receive the command "buy", print the items with their names and the total price of all the products with that name.

Input:
    •	Until you receive "buy", the products come in the format: "{name} {price} {quantity}".
    •	The product data is always delimited by a single space.

Output:
    •	Print information about each product, following the format: "{productName} -> {totalPrice}"
    •	Format the average total price to the 2nd decimal place.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] productsData = input.split(" ");
            String productName = productsData[0];
            double productPrice = Double.parseDouble(productsData[1]);
            int quantity = Integer.parseInt(productsData[2]);

            if (!productsQuantity.containsKey(productName)) {
                productsQuantity.put(productName, quantity);
            } else {
                int currentQuantity = productsQuantity.get(productName);
                productsQuantity.put(productName, currentQuantity + quantity);
            }
            productsPrice.put(productName, productPrice);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : productsPrice.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), productsQuantity.get(entry.getKey()) * entry.getValue());
        }
    }
}