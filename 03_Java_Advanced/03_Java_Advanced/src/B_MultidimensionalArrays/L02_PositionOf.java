package B_MultidimensionalArrays;

import java.util.*;

public class L02_PositionOf {

/*Write a program that reads a matrix of integers from the console, then a number, and prints all the positions at which
that number appears in the matrix. The matrix definition on the console will contain a line with two positive integer numbers
R and C – the number of rows and columns in the matrix – followed by R lines, each containing C numbers (separated by spaces),
representing each row of the matrix. The number you will need to find the positions will be entered on a single line after the matrix.
You should print each position on a single line – first print the row, then the column at which the number appears.
If the number does not appear in the matrix, print "not found".*/


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arrayOneDimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = arrayOneDimensions[0];
        int columns = arrayOneDimensions[1];
        int[][] matrix = new int[rows][columns];
        boolean isFound = false;

        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }

        int elementToFind = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns ; column++) {

                if (elementToFind == matrix[row][column]) {
                    System.out.printf("%d %d%n", row, column);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}