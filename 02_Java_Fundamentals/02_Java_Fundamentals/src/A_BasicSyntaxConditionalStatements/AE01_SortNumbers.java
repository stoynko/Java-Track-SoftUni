package A_BasicSyntaxConditionalStatements;

import java.util.*;

public class AE01_SortNumbers {

// Read three real numbers and sort them in descending order. Print each number on a new line.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberA = Integer.parseInt(scanner.nextLine());
        int numberB = Integer.parseInt(scanner.nextLine());
        int numberC = Integer.parseInt(scanner.nextLine());
        int top = 0;
        int mid = 0;
        int bottom = 0;

        if (numberA > numberB && numberA > numberC) {
            top = numberA;
            if (numberB > numberC) {
                mid = numberB;
                bottom = numberC;
            } else {
                mid = numberC;
                bottom = numberB;
            }
        } else if (numberB > numberA && numberB > numberC) {
            top = numberB;
            if (numberA > numberC) {
                mid = numberA;
                bottom = numberC;
            } else {
                mid = numberC;
                bottom = numberA;
            }
        } else if (numberC > numberA && numberC > numberB) {
            top = numberC;
            if (numberA > numberB) {
                mid = numberA;
                bottom = numberB;
            } else {
                mid = numberB;
                bottom = numberA;
            }
        }

        System.out.println(top);
        System.out.println(mid);
        System.out.println(bottom);
    }
}