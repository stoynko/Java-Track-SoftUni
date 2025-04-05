package C_Java_Advanced.B_MultidimensionalArrays;

import java.util.*;

public class L07_FindTheRealQueen {

/*Write a program that reads (8 x 8) matrix of characters from the console. The matrix represents a chessboard with figures on it.
The figures can be - queens as char 'q' or any other ASCII symbol. There will be more than one queen, but only one queen will have a valid position,
which is not attacked by any other queen and does not attack any other queen. In another word, in the way of the valid queen, there are no other queens,
but there may be any other ASCII symbol. Your task is to read the chessboard and find the position of the valid queen.
According to chess rules, the queen can attack all the cells in horizontal, verticals and both diagonals, which cross the queen position.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[][] chessboard = new String[8][8];
        fillMatrix(chessboard, scanner);
        ArrayList<String> coordinates = findQueensPosition(chessboard);

        while (true) {
            String coordinate = coordinates.getFirst();
            int x = Integer.parseInt(coordinate.split("\\s+")[0]);
            int y = Integer.parseInt(coordinate.split("\\s+")[1]);
            String originalValue = chessboard[x][y];
            chessboard[x][y] = " ";
            if (isQueenReal(chessboard, x, y)) {
                System.out.println(x + " " + y);
                break;
            } else {
                coordinates.remove(coordinate);
                chessboard[x][y] = originalValue;
            }
        }
    }

    private static boolean isQueenReal(String[][] chessboard, int x, int y) {

        return checkRowAndColumn(chessboard, x, y) &&
                checkMainDiagonalDownwards(chessboard, x, y) &&
                checkMainDiagonalUpwards(chessboard, x, y) &&
                checkSecondaryDiagonalUpwards(chessboard, x, y) &&
                checkSecondaryDiagonalDownwards(chessboard, x, y);
    }

    private static boolean checkRowAndColumn(String[][] chessboard, int x, int y) {

        for (int row = 0; row < chessboard.length; row++) {
            if (chessboard[row][y].equals("q") && row != x) {
                return false;
            }
        }

        for (int column = 0; column < chessboard.length; column++) {
            if (chessboard[x][column].equals("q") && column != y) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkMainDiagonalUpwards(String[][] chessboard, int x, int y) {

        int row = x - 1;
        int column = y - 1;
        while (row >= 0 && column >= 0) {
            if ((chessboard[row][column]).equals("q")) {
                return false;
            }
            row--;
            column--;
        }
        return true;
    }

    private static boolean checkMainDiagonalDownwards(String[][] chessboard, int x, int y) {

        int row = x + 1;
        int column = y + 1;
        while (row < chessboard.length && column < chessboard.length) {
            if ((chessboard[row][column]).equals("q")) {
                return false;
            }
            row++;
            column++;
        }
        return true;
    }

    private static boolean checkSecondaryDiagonalUpwards(String[][] chessboard, int x, int y) {

        int row = x - 1;
        int column = y + 1;
        while (row >= 0 && column < chessboard.length) {
            if (chessboard[row][column].equals("q")) {
                return false;
            }
            row--;
            column++;
        }
        return true;
    }

    private static boolean checkSecondaryDiagonalDownwards(String[][] chessboard, int x, int y) {

        int row = x + 1;
        int column = y - 1;
        while (row < chessboard.length && column >= 0) {
            if (chessboard[row][column].equals("q")) {
                return false;
            }
            row++;
            column--;
        }
        return true;
    }

    private static ArrayList<String> findQueensPosition(String[][] chessboard) {
        ArrayList<String> coordinates = new ArrayList<>();
        for (int currentRow = 0; currentRow < chessboard.length; currentRow++) {
            for (int currentColumn = 0; currentColumn < chessboard.length; currentColumn++) {
                if (chessboard[currentRow][currentColumn].equals("q")) {
                    coordinates.add(currentRow + " " + currentColumn);
                }
            }
        }
        return coordinates;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            matrix[row] = rowData;
        }
    }
}
