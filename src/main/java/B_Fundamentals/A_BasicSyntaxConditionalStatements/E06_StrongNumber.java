package B_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class E06_StrongNumber {

/*Write a program to check whether or not a given number is strong.
A number is strong if the sum of the Factorial of each digit is equal to the number.
For example 145 is a strong number, because 1! + 4! + 5! = 145.
Print "yes" if the number is strong and "no" if the number is not strong.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int integer = Integer.parseInt(scanner.nextLine());
        int initialInteger = integer;
        int totalFactorial = 0;

        while (integer > 0) {

            int currentDigit = integer % 10;
            int factorial = 1;
            for (int k = 2; k <= currentDigit; k++) {
                factorial = factorial * k;
            }
            totalFactorial += factorial;
            integer = integer / 10;
        }

        if (totalFactorial == initialInteger)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}