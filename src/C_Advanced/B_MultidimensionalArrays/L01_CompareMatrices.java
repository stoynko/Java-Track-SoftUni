package C_Advanced.B_MultidimensionalArrays;

import java.util.*;

public class L01_CompareMatrices {

/*Write a program that reads two integer matrices (2D arrays) from the console and compares them element by element.
For better code reusability, you could make the comparison in a method that returns true if they are equal and false if not.
Each matrix definition on the console will contain a line with a positive integer number R – the number of rows in the matrix and C – the number of columns – followed by R lines containing the C numbers,
separated by spaces (each line will have an equal amount of numbers. The matrices will have at most 10 rows and at most 10 columns.
Print "equal" if the matrices match and "not equal" if they don't match*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arrayOneDimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = arrayOneDimensions[0];
        int cols = arrayOneDimensions[1];
        int[][] arrayOne = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            arrayOne[i] = row;
        }

        int[] arrayTwoDimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        rows = arrayTwoDimensions[0];
        cols = arrayTwoDimensions[1];
        int[][] arrayTwo = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            arrayTwo[i] = row;
        }

        if (arraysAreEqual(arrayOne, arrayTwo)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean arraysAreEqual(int[][] arrayOne, int[][] arrayTwo) {
        if (arrayOne.length != arrayTwo.length) {
            return false;
        }
        for (int i = 0; i < arrayOne.length; i++) {
            if (arrayOne[i].length != arrayTwo[i].length) {
                return false;
            }
            for (int j = 0; j < arrayOne[i].length; j++) {
                if (arrayOne[i][j] != arrayTwo[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}