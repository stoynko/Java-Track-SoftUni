package B_MultidimensionalArrays;

import java.util.*;

public class L08_WrongMeasurements {

/*You will be given the rows of a matrix. Then the matrix itself. Inside this matrix, there are mistaken values that need to be replaced.
You will receive the wrong value at the last line. Those values should be replaced with the sum of the nearest elements in the four directions,
up, down, left, and right, but only if they are valid values. In the end, you have to print the fixed measurements.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[] rowData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int columns = rowData.length;
        int[][] matrix = new int[rows][columns];
        int[][] correctedMatrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            matrix[row] = rowData;
            if (!(row == rows - 1)) {
                rowData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
        }

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int wrongValue = matrix[coordinates[0]][coordinates[1]];

        for (int currentRow = 0; currentRow < rows; currentRow++) {
            for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
                if (matrix[currentRow][currentColumn] == wrongValue) {
                    int newValue = 0;
                    // Top Element
                    if (currentRow - 1 >= 0){
                        if (wrongValue != matrix[currentRow - 1][currentColumn]){
                        newValue += matrix[currentRow - 1][currentColumn];
                        }
                    }
                    // Bottom Element
                    if (currentRow + 1 < rows){
                        if (wrongValue != matrix[currentRow + 1][currentColumn]){
                            newValue += matrix[currentRow + 1][currentColumn];
                        }
                    }
                    // Left Element
                    if (currentColumn - 1 >= 0) {
                        if (wrongValue != matrix[currentRow][currentColumn - 1]){
                            newValue += matrix[currentRow][currentColumn - 1];
                        }
                    }
                    // Right Element
                    if (currentColumn + 1 < columns) {
                        if (wrongValue != matrix[currentRow][currentColumn + 1]){
                            newValue += matrix[currentRow][currentColumn + 1];
                        }
                    }
                    correctedMatrix[currentRow][currentColumn] = newValue;
                } else {
                    correctedMatrix[currentRow][currentColumn] = matrix[currentRow][currentColumn];
                }
            }
        }
        printMatrix(correctedMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.printf("%s ", matrix[row][column]);
            }
            System.out.println();
        }
    }
}
