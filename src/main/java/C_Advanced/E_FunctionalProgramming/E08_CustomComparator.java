package C_Advanced.E_FunctionalProgramming;

import java.util.*;

public class E08_CustomComparator {

/*Write a custom comparator that sorts all even numbers before all odd ones in ascending order.
Pass it to an Arrays.sort() function and print the result.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Comparator<Integer> customComparator = ((e1, e2) -> {
            if (e1 % 2 == 0 && e2 % 2 != 0) {
                return -1;
            } else if (e1 % 2 != 0 && e2 % 2 == 0) {
                return 1;
            } else {
                return e1.compareTo(e2);
            }
        });

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                        .map(Integer::parseInt)
                        .toList();

        numbers.stream().sorted(customComparator).forEach(number -> System.out.print(number + " "));
    }
}
