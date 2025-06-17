package B_DataTypesAndVariables;

import java.util.*;

public class AE04_RefactoringPrimeChecker {

/*You are given a program that checks if numbers in a given range [2...N] are prime.
For each number is printed "{number} -> {true or false}".
The code, however, is not very well written.
Your job is to modify it in a way that is easy to read and understand.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= n; i++) {

            boolean isPrime = true;
            for (int j = 2; j < i; j++) {

                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            System.out.printf("%d -> %b%n", i, isPrime);
        }
    }
}