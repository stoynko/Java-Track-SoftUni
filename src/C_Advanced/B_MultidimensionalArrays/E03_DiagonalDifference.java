package C_Advanced.B_MultidimensionalArrays;

import java.util.*;

public class E03_DiagonalDifference {

 //Write a program that finds the difference between the sums of the square matrix diagonals (absolute value).

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];

        fillMatrix(matrix, scanner);

        int primaryDiagonalSum = getPrimaryDiagonalSum(matrix);
        int secondaryDiagonalSum = getSecondaryDiagonalSum(matrix);
        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }
    private static int getPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row] == matrix[column]){
                    sum += matrix[row][column];
                }
            }
        }
        return sum;
    }
    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (column + row == matrix.length - 1) {
                    sum += matrix[row][column];
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length ; row++) {
            int[] rowData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowData;
        }
    }
}
