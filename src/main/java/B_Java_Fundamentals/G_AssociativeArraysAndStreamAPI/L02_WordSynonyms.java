package B_Java_Fundamentals.G_AssociativeArraysAndStreamAPI;

import java.util.*;

public class L02_WordSynonyms {

/*Write a program that keeps a map with synonyms. The key to the map will be the word. The value will be a list of all the synonyms of that word.
You will be given a number n. On the next 2 * n lines, you will be given the word and a synonym each on a separate line like this:
    •	{word}
    •	{synonym}

If you get the same word for the second time, just add the new synonym to the list. Print the words in the following format:
        {word} - {synonym1, synonym2… synonymN}*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> map = new LinkedHashMap<>();

        for (int currentWord = 1; currentWord <= n; currentWord++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}