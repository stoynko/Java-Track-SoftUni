package C_Advanced.B_MultidimensionalArrays;

import java.util.*;

public class E01_FillTheMatrix {

/*Filling a matrix regularly (top to bottom and left to right) is boring.
Write two methods that fill a size N x N matrix in two different patterns.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int[][] matrix = new int[Integer.parseInt(input[0])][Integer.parseInt(input[0])];
        String pattern = input[1];

        switch (pattern) {
            case "A" -> fillMatrixPatternA(matrix);
            case "B" -> fillMatrixPatternB(matrix);
        }
        printMatrix(matrix);
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int startingValue = 1;
        for (int column = 0; column < matrix.length; column++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][column] = startingValue;
                startingValue++;
            }
        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int startingValue = 1;
        for (int column = 0; column < matrix.length; column++) {
            if (column % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][column] = startingValue;
                    startingValue++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][column] = startingValue;
                    startingValue++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.printf("%d ", matrix[row][column]);
            }
            System.out.println();
        }
    }
}
