package B_Java_Fundamentals.H_TextProcessing;

import java.util.*;

public class L03_Substring {

    /*On the first line, you will receive a string. On the second line, you will receive a second string.
        Write a program that removes all of the occurrences of the first String in the second until there is no match.
        At the end, print the remaining String.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String substring = scanner.nextLine();
        String word = scanner.nextLine();

        while (word.contains(substring)) {
            word = word.replace(substring, "");
        }
        System.out.println(word);
    }
}