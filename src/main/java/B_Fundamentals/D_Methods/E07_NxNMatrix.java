package B_Fundamentals.D_Methods;

import java.util.*;

public class E07_NxNMatrix {

//*Write a method that receives a single integer n and prints an nxn matrix with that number*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printRow(n);
    }

    private static void printRow(int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }
    }
}
