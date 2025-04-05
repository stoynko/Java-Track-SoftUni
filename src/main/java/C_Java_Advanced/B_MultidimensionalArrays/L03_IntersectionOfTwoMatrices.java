package C_Java_Advanced.B_MultidimensionalArrays;

import java.util.*;

public class L03_IntersectionOfTwoMatrices {

/*Write a program that reads two char matrices (A[][] and B[][]) of the same order M * N and prints the third matrix C[][], which is filled with the intersecting elements of A and B,
otherwise set the element to '*'. On the first two lines, you receive M and N, then on 2 * M lines N characters – the matrices elements.
The matrix elements may be any ASCII char except '*'*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] matrixOne = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            matrixOne[i] = row;
        }

        String[][] matrixTwo = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            matrixTwo[i] = row;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrixOne[i][j].equals(matrixTwo[i][j])) {
                    System.out.printf("%s ", matrixOne[i][j]);
                } else {
                    System.out.printf("* ");
                }
            }
            System.out.println();
        }
    }
}