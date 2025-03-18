package B_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class E07_VendingMachine {

/*Your task is to calculate the total purchase price from a vending machine.
Until you receive "Start" you will be given different coins that are being inserted into the machine.
You have to sum them to have the total money inserted. There is a problem though.
Your vending machine only works with 0.1, 0.2, 0.5, 1, and 2 coins.
If someone tries to insert some other coins, you have to display "Cannot accept {money}",
where the value is formatted to the second digit after the decimal point and not add it to the total money.
On the next few lines until you receive "End" you will be given products to purchase.
Your machine has, however, only "Nuts", "Water", "Crisps", "Soda", "Coke". The prices are: 2.0, 0.7, 1.5, 0.8, 1.0 respectively.
If the person tries to purchase a not existing product, print "Invalid product".
Be careful that the person may try to purchase a product for which he doesn't have money. In that case, print "Sorry, not enough money".
If the person purchases a product successfully print "Purchased {product name}". After the "End" command,
print the money that is left formatted to the second decimal point in the format "Change: {money left}".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double total = 0;
        double costs = 0;
        boolean invalidProduct = false;
        boolean purchasingStarted = false;
        String purhcasedItem = "";

        while (!input.equals("End")) {
            if (!input.equals("Start")) {
                double insertedCoin = Double.parseDouble(input);
                if (insertedCoin == 0.1 || insertedCoin == 0.2 || insertedCoin == 0.5 || insertedCoin == 1 || insertedCoin == 2) {
                    total += insertedCoin;
                } else {
                    System.out.printf("Cannot accept %.2f %n", insertedCoin);
                }
            } else {
                purchasingStarted = true;
                input = scanner.nextLine();
                while (!input.equals("End")) {
                    switch (input) {
                        case "Nuts" -> {
                            costs = 2;
                            purhcasedItem = "Nuts";
                        }
                        case "Water" -> {
                            costs = 0.7;
                            purhcasedItem = "Water";
                        }
                        case "Crisps" -> {
                            costs = 1.5;
                            purhcasedItem = "Crisps";
                        }
                        case "Soda" -> {
                            costs = 0.8;
                            purhcasedItem = "Soda";
                        }
                        case "Coke" -> {
                            costs = 1;
                            purhcasedItem = "Coke";
                        }
                        default -> invalidProduct = true;
                    }
                    if (invalidProduct) {
                        System.out.println("Invalid product");
                    } else if (costs > total) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        total -= costs;
                        System.out.printf("Purchased %s%n", purhcasedItem);
                    }
                    input = scanner.nextLine();
                }
            }
            if (!purchasingStarted) {
                input = scanner.nextLine();
            }
        }

        System.out.printf("Change: %.2f", total);
    }
}