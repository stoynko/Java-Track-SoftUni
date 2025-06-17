package G_AssociativeArraysAndStreamAPI;

import java.util.*;

public class L04_WordFilter {

//Read an array of strings, and take only words whose length is even. Print each word on a new line.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] words = Arrays.stream(scanner.nextLine().split("\\s+")).filter(w -> w.length() % 2 == 0).toArray(String[]::new);

        for (String word : words) {
            System.out.println(word);
        }
    }
}