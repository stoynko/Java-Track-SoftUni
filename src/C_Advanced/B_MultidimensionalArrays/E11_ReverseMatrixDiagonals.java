package C_Advanced.B_MultidimensionalArrays;

import java.util.*;

public class E11_ReverseMatrixDiagonals {

/*You are given a matrix (2D array) of integers. You have to print the matrix diagonal but in reversed order. Print each diagonal on a new line.

Input:
On the first line, single integer the number R of rows in the matrix. On each of the next R lines, C numbers are separated by single spaces.
Note that R and C may have different values.

Output:
The output should consist of R lines, each consisting of exactly C characters, separated by spaces, representing the matrix diagonals reversed.

Constraints:
All the integers will be in the range [1….1000].*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);
        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, scanner);
        StringBuilder output = new StringBuilder();

        for (int diagonal = cols - 1; diagonal >= 0; diagonal--) {
            int row = rows - 1;
            int col = diagonal;

            while (row >= 0 && col < cols) {
                System.out.print(matrix[row--][col++] + " ");
            }
            System.out.println();
        }

        for (int startRow = rows - 2; startRow >= 0; startRow--) {

            int col = 0;
            int row = startRow;

            while (row >= 0 && col < cols) {
                System.out.print(matrix[row--][col++] + " ");
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
