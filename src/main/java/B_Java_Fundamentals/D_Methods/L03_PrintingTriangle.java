package B_Java_Fundamentals.D_Methods;

import java.util.*;

public class L03_PrintingTriangle {

/*Create a method for printing triangles*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        for (int currentRow = 1; currentRow <= rows; currentRow++) {
            printRow(currentRow, rows);
        }
        for (int currentRow = rows - 1; currentRow >= 1; currentRow--) {
            printRow(currentRow, rows);
        }
    }

    private static void printRow(int currentRow, int rows) {

        for (int i = 1; i <= currentRow; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}