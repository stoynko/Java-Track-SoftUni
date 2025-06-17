package B_MultidimensionalArrays;

import java.util.*;

public class L06_PrintDiagonalsOfSquareMatrix {

/*Write a program that reads a matrix from the console. Then print the diagonals. The matrix will always be square.
On the first line, you read a single integer N the matrix size. Then on each line N elements.
The first diagonal should always start with the element at the first row and col.
The second diagonal should start with the element at the last row and first col. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimensions][dimensions];

        for (int row = 0; row < matrix.length; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        for (int column = 0; column < matrix.length; column++) {
            System.out.print(matrix[matrix.length - 1 - column][column] + " ");
        }
    }
}
