package C_Advanced.E_FunctionalProgramming;

import java.util.*;
import java.util.stream.*;

public class L01_SortEvenNumbers {

/*Write a program that reads one line of Integers separated by ", ".
    •	Print the even numbers.
    •	Sort them in ascending order.
    •	Print them again.

Use 2 Lambda Expressions to do so.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> integers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .mapToObj(Integer::toString)
                .toList();

        System.out.println(String.join(", ", integers));

        integers = integers.stream().mapToInt(Integer::parseInt).sorted().mapToObj(Integer::toString).toList();

        System.out.println(String.join(", ", integers));
    }
}
