package A_Java_ProgrammingBasics.F_NestedLoops;

import java.util.*;

public class E03_SumPrimeNonPrime {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sumComplexNum = 0;
        int sumSimpleNum = 0;
        while (!input.equals("stop")) {
            int currentNum = Integer.parseInt(input);
            int subdivisionCounter = 0;
            if (currentNum < 0) {
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }

            for (int i = 1; i <= currentNum; i++) {
                if (currentNum % i == 0) {
                    subdivisionCounter++;
                }
            }
            if (subdivisionCounter > 2) {
                sumComplexNum += currentNum;
            } else if (subdivisionCounter == 2) {
                sumSimpleNum += currentNum;
            }
            input = scanner.nextLine();
        }

        System.out.printf("Sum of all prime numbers is: %d\n", sumSimpleNum);
        System.out.printf("Sum of all non prime numbers is: %d\n", sumComplexNum);
    }
}
