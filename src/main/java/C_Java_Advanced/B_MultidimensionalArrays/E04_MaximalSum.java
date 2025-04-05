package C_Java_Advanced.B_MultidimensionalArrays;

import java.util.*;

public class E04_MaximalSum {

/*Write a program that reads a rectangular integer matrix of size N x M and finds the square 3 x 3 with a maximal sum of its elements.
    Input:
    •	On the first line, you will receive the rows N and columns M.
    •	On the next N lines, you will receive each row with its elements.
Print the elements of the 3 x 3 square as a matrix, along with their sum. See the format of the output below.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];
        int[][] matrix = new int[rows][columns];
        int[][] subMatrix = new int[3][3];
        int highestSubMatrixSum = Integer.MIN_VALUE;
        fillMatrix(matrix, scanner);

        for (int currentRow = 0; currentRow < rows - 2; currentRow++) {
            for (int currentColumn = 0; currentColumn < columns - 2; currentColumn++) {
                int subMatrixSum = getSubmatrixSum(matrix, currentRow, currentColumn);

                if (subMatrixSum > highestSubMatrixSum) {
                    highestSubMatrixSum = subMatrixSum;
                    for (int row = 0; row < subMatrix.length; row++) {
                        for (int col = 0; col < subMatrix[row].length; col++) {
                            subMatrix[row][col] = matrix[currentRow + row][currentColumn + col];
                        }
                    }
                }
            }
        }
        System.out.printf("Sum = %d\n", highestSubMatrixSum);
        printMatrix(subMatrix);
    }

    private static int getSubmatrixSum(int[][] matrix, int row, int column) {
        int a00 = matrix[row][column];
        int a01 = matrix[row][column + 1];
        int a02 = matrix[row][column + 2];
        int a10 = matrix[row + 1][column];
        int a11 = matrix[row + 1][column + 1];
        int a12 = matrix[row + 1][column + 2];
        int a20 = matrix[row + 2][column];
        int a21 = matrix[row + 2][column + 1];
        int a22 = matrix[row + 2][column + 2];
        return a00 + a01 + a02 + a10 + a11 + a12 + a20 + a21 + a22;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.printf("%s ", matrix[row][column]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] rowData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowData;
        }
    }
}
