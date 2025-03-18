package C_Advanced.E_FunctionalProgramming;

import java.util.*;

public class E05_ReverseAndExclude {

//Write a program that reverses a collection and removes elements that are divisible by a given integer n.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                        .map(Integer::parseInt)
                        .toList());

        int divisor = Integer.parseInt(scanner.nextLine());
        Collections.reverse(numbers);
        numbers.stream().filter(number -> {
                    return number % divisor != 0;})
                    .forEach(number -> System.out.print(number + " "));
    }
}
