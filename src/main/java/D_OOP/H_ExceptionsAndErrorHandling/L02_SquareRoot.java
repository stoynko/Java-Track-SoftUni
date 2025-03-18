package D_OOP.H_ExceptionsAndErrorHandling;

import java.util.*;

public class L02_SquareRoot {

/*Write a program that reads an integer number and calculates and prints its square root (with 2 digits after the decimal point).
If the number is invalid, print "Invalid number". In all cases finally, print "Goodbye". Use try-catch-finally. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            int number = Integer.parseInt(input);
            if (number < 0) {
                System.out.println("Invalid");
            } else {
                System.out.printf("%.2f\n", Math.sqrt(number));
            }
        } catch (Exception e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }
}
