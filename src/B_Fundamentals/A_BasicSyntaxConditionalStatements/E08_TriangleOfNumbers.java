package B_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class E08_TriangleOfNumbers {

/*Write a program that receives a number – n and prints a triangle from 1 to n as in the examples.

Constraints
    • n will be in the interval [1...20].*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= i; k++) {

                System.out.print(i + " ");
            }

            System.out.println(" ");
        }
    }
}