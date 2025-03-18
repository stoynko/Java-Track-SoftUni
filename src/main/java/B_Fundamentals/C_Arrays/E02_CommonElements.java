package B_Fundamentals.C_Arrays;

import java.util.*;

public class E02_CommonElements {

//Write a program that prints common elements in two arrays. You have to compare the elements of the second array to the elements of the first.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] arrayA = scanner.nextLine().split(" ");
        String[] arrayB = scanner.nextLine().split(" ");

        for (String elementArrayB : arrayB) {
            for (String elementArrayA : arrayA) {
                if (elementArrayB.equals(elementArrayA)) {
                    System.out.printf("%s ", elementArrayB);
                }
            }
        }
    }
}
