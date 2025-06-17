package B_DataTypesAndVariables;

import java.util.*;

public class L10_SpecialNumbers {

/*A number is special when its sum of digits is 5, 7, or 11.
Write a program to read an integer n and for all numbers in the range 1…n to print the number
and if it is special or not (True / False).*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int range = Integer.parseInt(scanner.nextLine());

        for (int currentNumber = 1; currentNumber <= range; currentNumber++) {

            int secondDigit = currentNumber % 10;
            int firstDigit = currentNumber / 10;
            int sum = firstDigit + secondDigit;

            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True%n", currentNumber);
            } else {
                System.out.printf("%d -> False%n", currentNumber);
            }
        }
    }
}