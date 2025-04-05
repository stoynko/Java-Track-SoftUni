package C_Java_Advanced.E_FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class E07_FindTheSmallestElement {

/*Write a program that is using a custom function (written by you) to find the smallest integer in a sequence of integers.
The input could have more than one space. Your task is to collect the integers from the console, find the smallest one and print its index
(if more than one such elements exist, print the index of the rightmost one).*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                        .map(Integer::parseInt)
                        .toList();

        Function<List<Integer>, Integer> findTheSmallestInteger = index -> index.lastIndexOf(Collections.min(numbers));

        System.out.println(findTheSmallestInteger.apply(numbers));
    }
}
