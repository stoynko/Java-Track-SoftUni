package C_Advanced.E_FunctionalProgramming;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class L02_SumNumbers {

/*Write a program that reads one line of Integers separated by ", ". Print the count of the numbers and their sum.

Use a Function<String, Integer>.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> parseFunc = e -> Integer.parseInt(e);
        List<String> numbers = Arrays.stream(scanner.nextLine().split(", ")).toList();


        int elementsCount = numbers.size();
        int elementsSum = numbers.stream().mapToInt(parseFunc::apply).sum();
        System.out.printf("Count = %d\n", elementsCount);
        System.out.printf("Sum = %d\n", elementsSum);
    }
}
