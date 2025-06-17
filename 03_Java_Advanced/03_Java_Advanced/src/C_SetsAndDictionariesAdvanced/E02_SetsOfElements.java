package C_SetsAndDictionariesAdvanced;

import java.util.*;

public class E02_SetsOfElements {

/*On the first line, you are given the length of two sets, N and M. On the next N + M lines, there are N numbers that are in the first set and M
numbers that are in the second one. Find all non-repeating element that appears in both of them, and print them in the same order at the console:
    •	Set with length N = 4: {1, 3, 5, 7}
    •	Set with length M = 3: {3, 4, 5}
    •	Set that contains all repeating elements -> {3, 5}*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int firstSetLength = Integer.parseInt(input.split(" ")[0]);
        int secondSetLength = Integer.parseInt(input.split(" ")[1]);
        HashSet<Integer> firstSet = new LinkedHashSet<>();
        HashSet<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetLength ; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < secondSetLength ; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        HashSet<Integer> duplicatedNumbers = new LinkedHashSet<>();

        for (int number : firstSet) {
            if (secondSet.contains(number)) {
                duplicatedNumbers.add(number);
            }
        }
        duplicatedNumbers.forEach(n -> System.out.print(n + " "));
    }
}
