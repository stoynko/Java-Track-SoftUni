package C_Java_Advanced.E_FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class L03_CountUppercaseWords {

/*Write a program that reads one line of text from the console. Print the count of words that start with an Uppercase letter,
after that print all these words in the same order as you found them in the text. Use a Predicate<String>.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Predicate<String> filterUppercaseWords = word -> Character.isUpperCase(word.charAt(0));
        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+")).filter(filterUppercaseWords).toList();

        System.out.println(words.size());
        words.forEach(System.out::println);
        
    }
}
