package B_MultidimensionalArrays;

import java.util.*;

public class E07_Crossfire {

/*You will receive two integers, which represent the dimensions of a matrix. Then, you must fill the matrix with increasing integers starting from 1,
and continuing on every row, like this:
    •	first row: 1, 2, 3, …, n
    •	second row: n + 1, n + 2, n + 3, …, n + n
    •	third row: 2 * n + 1, 2 * n + 2, …, 2 * n + n
You will also receive several commands in the form of 3 integers separated by a space. Those 3 integers will represent a row in the matrix,
a column, and a radius. You must then destroy the cells, which correspond to those arguments cross-like. Destroying a cell means that
that cell becomes completely nonexistent in the matrix. Destroying cells cross-like means that you form a cross figure with a center point
- equal to the cell with coordinates – the given row and column, and lines with length equal to the given radius. See the examples for more info.
The input ends when you receive the command "Nuke it from orbit". When that happens, you must print what has remained from the initial matrix.
    Input
        •	On the first line, you will receive the dimensions of the matrix. You must then fill the matrix according to those dimensions.
        •	On the next several lines, you will receive 3 integers separated by a single space representing the row, col, and radius.
            It would help if you then destroyed cells according to those coordinates.
        •	When you receive the command "Nuke it from orbit" the input ends.
    Output
        •	The output is simple. You must print what is left from the matrix.
        •	Every row must be printed on a new line, and every column of a row - be separated by a space.
    Constraints
        •	The dimensions of the matrix will be integers in the range [2, 100].
        •	The given rows and columns will be valid integers in the range [-231 + 1, 231 - 1].
        •	 The radius will be in the range [0, 231 - 1].
        •	Allowed time/memory: 250ms/16MB.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];
        List<List<Integer>> matrix = new LinkedList<>();
        fillMatrix(matrix, rows, columns);
        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {

            String[] tokens = input.split("\\s+");
            int targetRow = Integer.parseInt(tokens[0]);
            int targetColumn = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            for (int currentRow = targetRow - radius; currentRow <= targetRow + radius; currentRow++) {
                if (isIndexValid(matrix, currentRow, targetColumn) && currentRow != targetRow)
                    matrix.get(currentRow).remove(targetColumn);
            }

            for (int currentColumn = targetColumn + radius; currentColumn >= targetColumn - radius; currentColumn--) {
                if (isIndexValid(matrix, targetRow, currentColumn)) {
                    matrix.get(targetRow).remove(currentColumn);
                }
            }
            matrix.removeIf(List::isEmpty);
            input = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean isIndexValid(List<List<Integer>> matrix, int row, int column) {
        return row >= 0 && row < matrix.size() && column >= 0 && column < matrix.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        StringBuilder output = new StringBuilder();
        for (List<Integer> row : matrix) {
            for (int num : row) {
                output.append(num).append(" ");
            }
            output.append("\n");
        }
        System.out.print(output.toString());
    }

    private static void fillMatrix(List<List<Integer>> matrix, int x, int y) {
        int initialValue = 1;
        for (int currentRow = 0; currentRow < x; currentRow++) {
            matrix.add(new ArrayList<>());
            for (int currentColumn = 0; currentColumn < y; currentColumn++) {
                matrix.get(currentRow).add(initialValue++);
            }
        }
    }
}

