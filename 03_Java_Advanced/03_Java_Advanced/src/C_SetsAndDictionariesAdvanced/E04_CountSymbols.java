package C_SetsAndDictionariesAdvanced;

import java.util.*;

public class E04_CountSymbols {

/*Write a program that reads some text from the console and counts the occurrences of each character in it.
Print the results in alphabetical (lexicographical) order.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> characters = new TreeMap<>();

        String input = scanner.nextLine();
        for (int index = 0; index < input.length(); index++) {
            if (!characters.containsKey(input.charAt(index))) {
                characters.put(input.charAt(index), 0);
            }
            characters.put(input.charAt(index), characters.get(input.charAt(index)) + 1);
        }

        characters.forEach((character, occurence) -> {
            System.out.printf("%s: %d time/s\n", character, occurence);
        });
    }
}

