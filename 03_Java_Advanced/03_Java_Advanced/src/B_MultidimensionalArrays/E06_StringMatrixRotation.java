package B_MultidimensionalArrays;

import java.util.*;
import java.util.regex.*;

public class E06_StringMatrixRotation {

/*You are given a sequence of text lines. Assume these text lines form a matrix of characters
(pad the missing positions with spaces to build a rectangular matrix). Write a program to rotate the matrix by 90, 180, 270, 360,… degrees.
Print the result as a sequence of strings at the console after receiving the "END" command.

Input
    •	The first line holds the command in the format "Rotate(X)" where X is the degrees of the requested rotation.
    •	The next lines contain the lines of the matrix for rotation.
    •	The input ends with the command "END".

The input data will always be valid and in the format described. There is no need to check it explicitly.

Output:
•	Print at the console the rotated matrix as a sequence of text lines.

Constraints
•	The rotation degree is a positive integer in the range [0…90000], where degrees are multiple of 90.
•	The number of matrix lines is in the range [1…1 000].
•	The matrix lines are strings of length 1 … 1 000.
•	It allowed a working time: 200ms/16MB.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int degrees = getDegrees(scanner);
        int columns = Integer.MIN_VALUE;
        List<String> words = new ArrayList<>();
        String word = scanner.nextLine();

        while (!word.equals("END")) {
            words.add(word);
            if (word.length() > columns) {
                columns = word.length();
            }
            word = scanner.nextLine();
        }
        int rows = words.size();
        String[][] matrix = new String[rows][columns];
        fillMatrix(matrix, words, columns);
        rotateMatrix(matrix, degrees);
    }

    private static void rotateMatrix(String[][] matrix, int degrees) {
        switch (degrees){
            case 90 -> {
                for (int currentColumn = 0; currentColumn < matrix[0].length; currentColumn++) {
                    for (int currentRow = matrix.length - 1; currentRow >= 0  ; currentRow--) {
                        System.out.print(matrix[currentRow][currentColumn]);
                    }
                    System.out.println();
                }
            }
            case 180 -> {
                for (int currentRow = matrix.length - 1; currentRow >= 0; currentRow--) {
                    for (int currentColumn = matrix[0].length - 1; currentColumn >= 0 ; currentColumn--) {
                        System.out.print(matrix[currentRow][currentColumn]);
                    }
                    System.out.println();
                }
            }
            case 270 -> {
                for (int currentColumn = matrix[0].length - 1; currentColumn >= 0 ; currentColumn--) {
                    for (int currentRow = 0; currentRow < matrix.length; currentRow++) {
                        System.out.print(matrix[currentRow][currentColumn]);
                    }
                    System.out.println();
                }
            }
            default -> {
                for (int currentRow = 0; currentRow < matrix.length; currentRow++) {
                    for (int currentColumn = 0; currentColumn < matrix[0].length; currentColumn++) {
                        System.out.print(matrix[currentRow][currentColumn]);
                    }
                    System.out.println();
                }
            }
        }
    }

    private static void fillMatrix(String[][] matrix, List<String> words, int maxLength) {
        for (int row = 0; row < words.size(); row++) {
            StringBuilder currentWord = new StringBuilder(words.get(row));
            while (currentWord.length() < maxLength) {
                currentWord.append(" ");
            }
            String[] rowData = currentWord.toString().split("");
            matrix[row] = rowData;
        }
    }

    private static int getDegrees(Scanner scanner) {

        String regex = "(?<degrees>[0-9]{2,5})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scanner.nextLine());

        if (matcher.find()) {
            return Integer.parseInt(matcher.group("degrees")) % 360;
        }
        return 0;
    }
}