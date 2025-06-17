package E_FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class E01_ConsumerPrint {

/*Write a program that reads a collection of strings, separated by one or more whitespaces, from the console and then prints them onto the console.
Each string should be printed on a new line. Use a Consumer<T>.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).toList();
        Consumer<String> consumerPrint = e -> System.out.println(e);

        names.forEach(consumerPrint);
    }
}
