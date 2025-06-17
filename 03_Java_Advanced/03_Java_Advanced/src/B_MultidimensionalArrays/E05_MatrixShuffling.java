package B_MultidimensionalArrays;

import java.util.*;

public class E05_MatrixShuffling {

/*Write a program which reads a string matrix from the console and performs certain operations with its elements.
User input is provided similarly to the problems above – first, you read the dimensions and then the data.
Your program should then receive commands in the format:
"swap row1 col1 row2c col2" where row1, row2, col1, col2 are coordinates in the matrix.
For a command to be valid, it should start with the "swap" keyword along with four valid coordinates (no more, no less).
You should swap the values at the given coordinates (cell [row1, col1] with cell [row2, col2]) and print the matrix at each step
(this you'll be able to check if the operation was performed correctly).
If the command is not valid (doesn't contain the keyword "swap", has fewer or more coordinates entered,
or the given coordinates do not exist), print "Invalid input!" and move on to the next command.
Your program should finish when the string "END" is entered.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[dimensions[0]][dimensions[1]];

        fillMatrix(matrix, scanner);
        String inputData = scanner.nextLine();
        while (!inputData.equals("END")) {

            if (isCommandValid(inputData, dimensions)) {
                int row1 = Integer.parseInt(inputData.split(" ")[1]);
                int col1 = Integer.parseInt(inputData.split(" ")[2]);
                int row2 = Integer.parseInt(inputData.split(" ")[3]);
                int col2 = Integer.parseInt(inputData.split(" ")[4]);
                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];
                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            inputData = scanner.nextLine();
        }
    }

    private static boolean isCommandValid(String s, int[] matrixDimensions) {

        String[] tokens = s.split(" ");

        if (!(tokens.length == 5)) {
            return false;
        }

        int row1 = Integer.parseInt(tokens[1]);
        int col1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int col2 = Integer.parseInt(tokens[4]);
        int rows = matrixDimensions[0];
        int columns = matrixDimensions[1];

        if (!tokens[0].equals("swap")) {
            return false;
        }
        if (row1 < 0 || row1 >= rows || col1 < 0 || col1 >= columns || row2 < 0 || row2 >= rows || col2 < 0 || col2 >= columns) {
            return false;
        }
        return true;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.printf("%s ", matrix[row][column]);
            }
            System.out.println();
        }
    }
}
