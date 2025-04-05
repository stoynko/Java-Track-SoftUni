package B_Java_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class L02_Passed {

/*Write a program that:
    •	Read a floating-point number, which represents a grade
    •	If the grade is equal or more than 3.00, print "Passed!"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());

        if (grade >= 3) {
            System.out.println("Passed!");
        }
    }
}