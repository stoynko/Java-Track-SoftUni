package C_Advanced.E_FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class E02_KnightsOfHonor {

/*Write a program that reads a collection of names as strings from the console and then appends "Sir" in front of every name and
prints it back onto the console. Use a Consumer<T>.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).toList();
        Consumer<String> consumerPrint = e -> System.out.println("Sir " + e);
        names.forEach(consumerPrint);
    }
}
