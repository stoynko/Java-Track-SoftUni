package C_Java_Advanced.E_FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class L06_FindEvensOrOdds {

/*You are given a lower and an upper bound for a range of integer numbers.
Then a command specifies if you need to list all even or odd numbers in the given range.
Use predicates that need to be passed to a method.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int lowerBound = Integer.parseInt(input[0]);
        int upperBound = Integer.parseInt(input[1]);
        String parameter = scanner.nextLine();

        Predicate<Integer> filterByParam = getPredicament(parameter);

        for (int i = lowerBound; i <= upperBound; i++) {

            if (filterByParam.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static Predicate<Integer> getPredicament(String parametar) {
        switch (parametar) {
            case "even" -> {
                return e -> e % 2 == 0;
            }
            case "odd" -> {
                return e -> e % 2 != 0;
            }
        }
        return null;
    }
}
