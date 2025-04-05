package B_Java_Fundamentals.X_MidExam.ExamPrep_V01;

import java.util.*;

public class P01_ComputerStore {

/*Write a program that prints you a receipt for your new computer.
You will receive the parts' prices (without tax) until you receive what type of customer this is - special or regular.
Once you receive the type of customer you should print the receipt.

The taxes are 20% of each part's price you receive. If the customer is special, he has a 10% discount on the total price with taxes.
If a given price is not a positive number, you should print "Invalid price!" on the console and continue with the next price.
If the total price is equal to zero, you should print "Invalid order!" on the console.

Input:
    • You will receive numbers representing prices (without tax) until the command "special" or "regular":

Output:
    • The receipt should be in the following format:
        "Congratulations you've just bought a new computer!
        "Price without taxes: {total price without taxes}"
        "Taxes: {total amount of taxes}"
        -----------
        "Total price: {total price with taxes}"

Note: All prices should be displayed to the second digit after the decimal point! The discount is applied only on the total price.
Discount is only applicable to the final price!*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //

        String input = scanner.nextLine();
        String customerType = "";
        double totalBasePrice = 0;
        double totalFinalPrice = 0;

        while (true) {

            if (input.equals("regular")) {
                break;
            } else if (input.equals("special")) {
                customerType = "special";
                break;
            } else {
                double basePrice = Double.parseDouble(input);
                if (checkIfPriceIsValid(basePrice)) {
                    totalBasePrice += basePrice;
                } else {
                    System.out.println("Invalid price!");
                }
            }
            input = scanner.nextLine();
        }

        if (totalBasePrice <= 0) {
            System.out.println("Invalid order!");
        } else {
            double taxes = totalBasePrice * 0.2;
            totalFinalPrice = totalBasePrice + taxes;
            if (customerType.equals("special")) {
                totalFinalPrice = totalFinalPrice * 0.9;
            }
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalBasePrice);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n", totalFinalPrice);
        }
    }

    private static boolean checkIfPriceIsValid(double amount) {
        return amount > 0;
    }
}