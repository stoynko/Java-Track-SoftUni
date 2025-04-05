package C_Java_Advanced.E_FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class E09_ListOfPredicates {

//Find all numbers in the range 1..N that is divisible by the numbers of a given sequence. Use predicates.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> divisors = Arrays.stream(scanner.nextLine()
                            .split("\\s+"))
                            .map(Integer::parseInt)
                            .toList();

        Predicate<Integer> isDivisible = number -> {
            for (int divisor : divisors) {
                if (number % divisor != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int number = 1; number <= n; number++) {
            if (isDivisible.test(number)) {
                System.out.print(number + " ");
            }
        }

    }
}
