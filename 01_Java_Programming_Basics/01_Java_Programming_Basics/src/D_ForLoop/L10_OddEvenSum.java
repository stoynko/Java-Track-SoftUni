package D_ForLoop;

import java.util.*;

public class L10_OddEvenSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sumEven = 0;
        int sumOdd = 0;
        boolean even = true;

        for (int i = 0; i < n; i++) {
            if (even) {
                sumEven += Integer.parseInt(scanner.nextLine());
                even = false;
            } else {
                sumOdd += Integer.parseInt(scanner.nextLine());
                even = true;
            }
        }
        if (sumEven == sumOdd) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", sumEven);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(sumEven - sumOdd));
        }
    }
}