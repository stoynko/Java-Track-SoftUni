package Y_FinalExam.ExamPrep_V06;

import java.util.*;

public class P03_BakeryShop {

/*Create a program that keeps the information about the stock at the shop.
You will be receiving lines with commands until you receive the "Complete" command. The possible commands are:
    •	"Receive {quantity} {food}":
        o	Add the quantity to the given food.
        o	If the food does not exist, add it to your record.
        o	If the quantity is invalid (<= 0), ignore the command.
    •	"Sell {quantity} {food}":
        o	If the food is not in your record, print: "You do not have any {food}.".
                o	If there is not enough quantity of the wanted food, you should sell (decrease) what you have in stock and then remove the food from your record.
                Print: "There aren't enough {food}. You sold the last {sold quantity} of them."
        o	Otherwise, decrease the quantity of the given food and print:  "You sold {quantity} {food}.". If, after reducing the quantity, there is 0 amount of this food, you should remove it from your record.
You must keep track of all sold food quantities!
In the end, you should print the stock availability in the format:
    "{food1}: {quantity}
    {food2}: {quantity}
    …
    {foodN}: {quantity}
All sold: {count of all sold food quantity} goods"

Input:
•	You will be receiving lines until you receive the "Complete" command.
•	The input will always be valid.
Output:
•	Print the stock availability in the format described above.
•	Print the amount of all sold food in the format described above.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> productsStock = new LinkedHashMap<>();
        int soldQuantities = 0;

        while (!input.equals("Complete")) {
            String command = input.split("\\s+")[0];
            switch (command) {

                case "Receive" -> {
                    String productName = input.split("\\s+")[2];
                    int quantity = Integer.parseInt(input.split("\\s+")[1]);
                    if (quantity > 0) {
                        productsStock.putIfAbsent(productName, 0);
                        productsStock.put(productName, productsStock.get(productName) + quantity);
                    }
                }
                case "Sell" -> {
                    String productName = input.split("\\s+")[2];
                    int quantity = Integer.parseInt(input.split("\\s+")[1]);

                    if (productsStock.containsKey(productName)) {
                        if (productsStock.get(productName) - quantity >= 0) {
                            productsStock.put(productName, productsStock.get(productName) - quantity);
                            soldQuantities += quantity;
                            System.out.printf("You sold %d %s.\n", quantity, productName);
                            if (productsStock.get(productName) == 0) {
                                productsStock.remove(productName);
                            }
                        } else if (productsStock.get(productName) - quantity < 0) {
                            soldQuantities += productsStock.get(productName);
                            System.out.printf("There aren't enough %s. You sold the last %d of them.\n", productName, productsStock.get(productName));
                            productsStock.remove(productName);
                        }
                    } else {
                        System.out.printf("You do not have any %s.\n", productName);
                    }
                }
            }
            input = scanner.nextLine();
        }
        productsStock.forEach((product, quantity) -> System.out.printf("%s: %d\n", product, quantity));
        System.out.printf("All sold: %d goods\n", soldQuantities);
    }
}