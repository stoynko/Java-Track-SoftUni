package A_BasicSyntaxConditionalStatements;

import java.util.*;

public class E02_Division {

 /*You will be given an integer, and you have to print on the console whether that number is divisible by the following numbers: 2, 3, 6, 7, 10.
You should always take the bigger division. If the number is divisible by both 2 and 3 it is also divisible by 6, and you should print only the division by 6.
If a number is divisible by 2 it is sometimes also divisible by 10, and you should print the division by 10.
If the number is not divisible by any given number, print "Not divisible". Otherwise, print "The number is divisible by {number}".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int integer = Integer.parseInt(scanner.nextLine());
        boolean isDivisible = false;
        int[] divisors = {2, 3, 6, 7, 10};
        int maxDivisor = Integer.MIN_VALUE;

        for (int i = 0; i < divisors.length; i++) {

            if (integer % divisors[i] == 0) {
                maxDivisor = divisors[i];
                isDivisible = true;
            }
        }

        if (isDivisible)
            System.out.printf("The number is divisible by %d", maxDivisor);
        else
            System.out.println("Not divisible");
    }
}