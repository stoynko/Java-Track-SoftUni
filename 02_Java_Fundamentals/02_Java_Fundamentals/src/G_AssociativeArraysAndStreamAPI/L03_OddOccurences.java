package G_AssociativeArraysAndStreamAPI;

import java.util.*;

public class L03_OddOccurences {

/*Write a program that extracts from a given sequence of words all elements that are present in it an odd number of times (case-insensitive).
    •	Words are given in a single line, space-separated.
    •	Print the result elements in lowercase in their order of appearance.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = Arrays.stream(scanner.nextLine().split("\\s+")).map(String::toLowerCase).toArray(String[]::new);
        Map<String, Integer> map = new LinkedHashMap<>();

        for (String word : input) {
            map.putIfAbsent(word, 0);
            map.put(word, map.get(word) + 1);
        }

        List<String> output = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                output.add(entry.getKey());
            }
        }

        System.out.printf("%s", String.join(", ", output));
    }
}
