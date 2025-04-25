package A_Java_ProgrammingBasics.F_NestedLoops;

import java.util.*;

public class E02_EqualSumsEvenOddPosition {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        boolean flag = false;

        for (int j = start; j <= end; j++) {
            String currentNum = String.valueOf(j);
            int sumEven = 0;
            int sumOdd = 0;

            for (int i = 0; i < currentNum.length(); i++) {
                int currentDigit = Integer.parseInt(String.valueOf(currentNum.charAt(i)));
                if (i % 2 == 0) {
                    sumOdd += currentDigit;
                } else {
                    sumEven += currentDigit;
                }
            }
            if (sumEven == sumOdd) {
                System.out.printf("%s ", currentNum);
            }
        }
    }
}