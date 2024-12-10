package B_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class AE03_GamingStore {

/*Write a program that helps you buy the games. The valid games are the following games in this table:

Name	                        Price
OutFall 4	                    $39.99
CS: OG	                        $15.99
Zplinter Zell	                $19.99
Honored 2	                    $59.99
RoverWatch	                    $29.99
RoverWatch Origins Edition	    $39.99

On the first line, you will receive your current balance – a floating-point number in the range [0.00…5000.00].
Until you receive the command "Game Time", you have to keep buying games. When a game is bought, the user's balance decreases by the price of the game.

Additionally, the program should obey the following conditions:
    •	If a game the user is trying to buy is not present in the table above, print "Not Found" and read the next line.
    •	If at any point, the user has $0 left, print "Out of money!" and end the program.
    •	Alternatively, if the user is trying to buy a game that they can't afford, print "Too Expensive" and read the next line.

When you receive "Game Time", print the user's remaining money and total spent on games, rounded to the 2nd decimal place.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double balance = Double.parseDouble(scanner.nextLine());
        double cost = 0;
        double totalCost = 0;
        String purhcasedItem = "";
        boolean invalidProduct = false;
        boolean outOfMoney = false;
        String input = scanner.nextLine();

        while (true) {
            if (balance <= 0) {
                outOfMoney = true;
                break;
            }
            if (input.equals("Game Time")) {
                break;
            }
            switch (input) {
                case "OutFall 4" -> {
                    cost = 39.99;
                    purhcasedItem = "OutFall 4";
                }
                case "CS: OG" -> {
                    cost = 15.99;
                    purhcasedItem = "CS: OG";
                }
                case "Zplinter Zell" -> {
                    cost = 19.99;
                    purhcasedItem = "Zplinter Zell";
                }
                case "Honored 2" -> {
                    cost = 59.99;
                    purhcasedItem = "Honored 2";
                }
                case "RoverWatch" -> {
                    cost = 29.99;
                    purhcasedItem = "RoverWatch";
                }
                case "RoverWatch Origins Edition" -> {
                    cost = 39.99;
                    purhcasedItem = "RoverWatch Origins Edition";
                }
                default -> invalidProduct = true;
            }

            if (invalidProduct) {
                System.out.println("Not Found");
                invalidProduct = false;
            } else if (cost > balance) {
                System.out.println("Too Expensive");
            } else {
                balance -= cost;
                totalCost += cost;
                System.out.printf("Bought %s%n", purhcasedItem);
            }
            input = scanner.nextLine();
        }

        if (!outOfMoney) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalCost, balance);
        } else {
            System.out.println("Out of money!");
        }

    }
}