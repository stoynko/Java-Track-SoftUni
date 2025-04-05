package B_Java_Fundamentals.D_Methods;

import java.util.*;

public class E01_SmallestOfThreeNumbers {

/*Write a method to print the smallest of three integer numbers. Use an appropriate name for the method.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberA = Integer.parseInt(scanner.nextLine());
        int numberB = Integer.parseInt(scanner.nextLine());
        int numberC = Integer.parseInt(scanner.nextLine());
        System.out.println(getSmallest(numberA, numberB, numberC));
    }

    private static int getSmallest(int numberA, int numberB, int numberC) {
        return Math.min(Math.min(numberA, numberB), numberC);
    }
}