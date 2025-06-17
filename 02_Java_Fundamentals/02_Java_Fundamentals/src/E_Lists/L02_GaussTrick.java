package E_Lists;

import java.util.*;
import java.util.stream.*;

public class L02_GaussTrick {

/*Write a program that sum all numbers in a list in the following order:
first + last, first + 1 + last - 1, first + 2 + last - 2, … first + n, last - n.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> integers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        List<Integer> summedIntegers = new ArrayList<>();

        for (int n = 0; n < integers.size() / 2; n++) {
            summedIntegers.add(integers.get(n) + integers.get(integers.size() - 1 - n));
        }
        if (integers.size() % 2 != 0) {
            summedIntegers.add(integers.get(integers.size() / 2));
        }
        for (int integer : summedIntegers) {
            System.out.printf("%d ", integer);
        }
    }
}