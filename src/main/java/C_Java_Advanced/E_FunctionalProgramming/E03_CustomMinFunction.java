package C_Java_Advanced.E_FunctionalProgramming;

import java.util.*;

public class E03_CustomMinFunction {

/*Write a simple program that reads a set of numbers from the console and finds the smallest of the numbers
using a simple Function<Integer[], Integer>.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                        .map(number -> Integer.parseInt(number))
                        .toList();

        System.out.println(Collections.min(numbers));
    }
}
