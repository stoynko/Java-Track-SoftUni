package C_Advanced.E_FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class E04_AppliedArithmetics {

/*On the first line, you are given a list of numbers. On the next lines you are passed different commands that you need to apply to all numbers
in the list: "add" -> adds 1; "multiply" -> multiplies by 2; "subtract" -> subtracts 1; "print" -> prints all numbers on a new line.
The input will end with an "end" command, after which the result must be printed.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Function<Integer, Integer> functionAdd = number -> number + 1;
        Function<Integer, Integer> functionMultiply = number -> number * 2;
        Function<Integer, Integer> functionSubtract = number -> number - 1;
        Consumer<Integer> consumerPrint = number -> System.out.print(number + " ");

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                        .map(Integer::parseInt)
                        .toList();

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {
                case "add" -> numbers = numbers.stream().map(functionAdd).toList();
                case "subtract" -> numbers = numbers.stream().map(functionSubtract).toList();
                case "multiply" -> numbers = numbers.stream().map(functionMultiply).toList();
                case "print" -> {
                    numbers.forEach(consumerPrint);
                    System.out.println();
                }
            }

            command = scanner.nextLine();
        }
    }
}
