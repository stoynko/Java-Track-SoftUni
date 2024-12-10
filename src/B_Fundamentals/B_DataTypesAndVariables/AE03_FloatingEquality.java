package B_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class AE03_FloatingEquality {

/*Write a program that safely compares floating-point numbers (double) with precision eps = 0.000001.
Note that we cannot directly compare two floating-point numbers a and b by a==b because of the nature of the floating-point arithmetic.
Therefore, we assume two numbers are equal if they are closer to each other than some fixed constant eps.
You will receive two lines, each containing a floating-point number. Your task is to compare the values of the two numbers.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double numberA = Double.parseDouble(scanner.nextLine());
        double numberB = Double.parseDouble(scanner.nextLine());

        boolean isEqual = false;
        double eps = 0.000001;
        double difference = 0;

        if (numberA > numberB) {
            difference = numberA - numberB;
        } else {
            difference = numberB - numberA;
        }

        isEqual = !(difference >= eps);
        if (isEqual) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}