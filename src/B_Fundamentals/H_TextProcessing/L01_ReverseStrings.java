package B_Fundamentals.H_TextProcessing;

import java.util.*;

public class L01_ReverseStrings {

/*You will be given a series of strings until you receive an "end" command.
Write a program that reverses strings and prints each pair on a separate line in the format "{word} = {reversed word}".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        while (!word.equals("end")) {

            String reversedWord = "";

            for (int index = word.length() - 1; index >= 0; index--) {
                char currentSymbol = word.charAt(index);
                reversedWord += currentSymbol;
            }

            System.out.printf("%s = %s%n", word, reversedWord);
            word = scanner.nextLine();
        }
    }
}
