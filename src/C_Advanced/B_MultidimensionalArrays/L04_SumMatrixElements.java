package C_Advanced.B_MultidimensionalArrays;

import java.util.*;

public class L04_SumMatrixElements {

/*Write a program that reads a matrix from the console and prints:

· The count of rows
· The count of columns
· The sum of all matrix's elements

On the first line, you will get the matrix dimensions in the format "{rows, columns}". On the next lines, you will get the elements for each row separated by a comma.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[matrixDimensions[0]][matrixDimensions[1]];

        for (int row = 0; row < matrixDimensions[0]; row++) {
            int[] matrixRow = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = matrixRow;
            sum += Arrays.stream(matrixRow).sum();
        }

        System.out.println(matrixDimensions[0]);
        System.out.println(matrixDimensions[1]);
        System.out.println(sum);
    }
}