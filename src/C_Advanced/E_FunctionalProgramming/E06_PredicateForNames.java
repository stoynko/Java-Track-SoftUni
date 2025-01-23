package C_Advanced.E_FunctionalProgramming;

import java.util.*;

public class E06_PredicateForNames {

/*Write a predicate. Its goal is to check a name for its length and to return true if the length of the name is less or equal to the passed integer.
You will be given an integer that represents the length you have to use. On the second line, you will be given a string array with some names.
Print the names, passing the condition in the predicate. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int stringLength = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

        names.stream().filter(name -> name.length() <= stringLength).forEach(name -> System.out.println(name));
    }
}
