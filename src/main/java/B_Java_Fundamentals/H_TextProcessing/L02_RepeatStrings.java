package B_Java_Fundamentals.H_TextProcessing;

import java.util.*;

public class L02_RepeatStrings {

    /*Write a Program That Reads an Array of Strings.
        Each String is Repeated N Times, Where N is the length of the String.
        Print the Concatenated String.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int index = 0; index <= words.length - 1; index++) {
            int cycles = words[index].length();
            for (int i = 1; i <= cycles; i++) {
                result.append(words[index]);
            }
        }
        System.out.println(result);
    }
}