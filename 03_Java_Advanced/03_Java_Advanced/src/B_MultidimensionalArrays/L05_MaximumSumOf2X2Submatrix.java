package B_MultidimensionalArrays;

import java.util.*;

public class L05_MaximumSumOf2X2Submatrix {

/*Write a program that reads a matrix from the console. Then find the biggest sum of a 2x2 submatrix.
Print the submatrix and its sum. On the first line, you will get the matrix dimensions in the format "{rows, columns}".
On the next lines, you will get the elements for each row separated by a comma.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int columns = matrixDimensions[1];
        int highestSum = Integer.MIN_VALUE;

        int[][] matrix = new int[rows][columns];
        int[][] subMatrix = new int[2][2];

        fillMatrix(matrix, scanner);

        for (int currentRow = 0; currentRow < rows - 1; currentRow++) {
            for (int currentColumn = 0; currentColumn < columns - 1; currentColumn++) {
                int a00 = matrix[currentRow][currentColumn];
                int a01 = matrix[currentRow][currentColumn + 1];
                int a10 = matrix[currentRow + 1][currentColumn];
                int a11 = matrix[currentRow + 1][currentColumn + 1];
                int tempSum = a00 + a01 + a10 + a11;
                if (tempSum > highestSum) {
                    highestSum = tempSum;
                    subMatrix[0][0] = a00;
                    subMatrix[0][1] = a01;
                    subMatrix[1][0] = a10;
                    subMatrix[1][1] = a11;
                }
            }
        }
        printMatrix(subMatrix);
        System.out.println(highestSum);
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] rowData = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowData;
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}