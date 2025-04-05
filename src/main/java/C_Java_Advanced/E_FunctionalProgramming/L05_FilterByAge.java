package C_Java_Advanced.E_FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class L05_FilterByAge {

/*Write a program that reads an integer N on the first line. And on next N lines read pairs of "{name}, {age}". Then read three more lines:

    •	Condition - "younger" or "older"
    •	Age - Integer
    •	Format - "name", "age" or "name age"
Depending on the condition, print the pairs in the right format. Don't use any built-in functionality. Write your methods.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split(", ")[0];
            int age = Integer.parseInt(input.split(", ")[1]);
            people.put(name, age);
        }

        String condition = scanner.nextLine();
        int years = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Map.Entry<String, Integer>> filterByAge = getPredicate(condition, years);
        Consumer<Map.Entry<String, Integer>> printFormat = getFormat(format);
        people.entrySet().stream().filter(filterByAge).forEach(printFormat);
    }

    private static Consumer<Map.Entry<String, Integer>> getFormat(String format) {

        switch (format) {
            case "name" -> {return person -> System.out.printf("%s\n", person.getKey());}
            case "age" -> {return person -> System.out.printf("%d\n", person.getValue());}
            case "name age" -> {return person -> System.out.printf("%s - %d\n", person.getKey(), person.getValue());}
        }
        return null;
    }

    private static Predicate<Map.Entry<String, Integer>> getPredicate (String condition, int years) {

        switch (condition) {
            case "younger" -> {return person -> person.getValue() <= years;}
            case "older" -> {return person -> person.getValue() >= years;}
        }
        return null;
    }
}
