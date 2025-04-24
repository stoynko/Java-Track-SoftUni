package A_Java_ProgrammingBasics.D_ForLoop;

import java.util.*;

public class L09_LeftAndRightSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < n; i++) {
            sumA += Integer.parseInt(scanner.nextLine());
        }
        for (int j = 0; j < n; j++) {
            sumB += Integer.parseInt(scanner.nextLine());
        }
        if (sumA == sumB) {
            System.out.printf("Yes, sum = %d", sumA);
        } else {
            System.out.printf("No, diff = %d", Math.abs(sumA - sumB));
        }
    }
}
