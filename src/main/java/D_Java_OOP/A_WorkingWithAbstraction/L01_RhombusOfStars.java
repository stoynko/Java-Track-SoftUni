package D_Java_OOP.A_WorkingWithAbstraction;

import java.util.*;

public class L01_RhombusOfStars {

//Create a program that reads a positive integer n as input and prints on the console a rhombus with size n:

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        printRhombus(size);

    }

    private static void printRhombus(int size) {

        if (size == 1) {
            System.out.println("*");
            return;
        }

        for (int row = 1; row <= size; row++) {

            printRow(size, row);
        }

        for (int row = size - 1; row > 0; row--) {

            printRow(size, row);
        }
    }

    private static void printRow(int size, int row) {

        for (int i = size - row; i > 0; i--) {
            System.out.print(" ");
        }

        for (int i = 1; i <= row; i++) {
            System.out.print("* ");
        }

        System.out.println();
    }
}
