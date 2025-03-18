package B_Fundamentals.H_TextProcessing;

import java.util.*;

public class L04_TextFilter {

/*Write a program that takes a text and a string of banned words.
All words included in the ban list should be replaced with asterisks "*", equal to the word's length.
The entries in the ban list will be separated by a comma and space ", ".
The ban list should be entered on the first input line and the text on the second input line.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] wordsToRemove = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : wordsToRemove) {

            if (text.contains(word)) {
                String censoredWord = "";
                for (int index = 0; index <= word.length() - 1; index++) {
                    censoredWord += "*";
                }
                text = text.replace(word, censoredWord);
            }
        }
        System.out.println(text);
    }
}