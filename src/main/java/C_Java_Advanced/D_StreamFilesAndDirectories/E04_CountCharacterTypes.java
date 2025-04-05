package C_Java_Advanced.D_StreamFilesAndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class E04_CountCharacterTypes {

/*Write a program that reads a list of words from the file ("input.txt" from the Resources - Exercises) and finds the count of vowels, other symbols, and punctuation marks. Assume that:
    •	a, e, i, o, u are vowels, only lower case.
    •	All others are other symbols.
    •	Punctuation marks are (! , . ?).
    •	Do not count whitespace.
Write the results to another file – "output.txt". */

    public static void main(String[] args) throws IOException {

        String pathIn = "src/C_Advanced/StreamFilesAndDirectories/resources/Exercise/input.txt";
        String pathOut = "src/C_Advanced/StreamFilesAndDirectories/resources/Exercise/output.txt";
        List<Character> vowels = new ArrayList<>();
        List<Character> punctuationSymbols = new ArrayList<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');
        Collections.addAll(punctuationSymbols, '!', ',', '.', '?');

        String input = Files.readString(Path.of(pathIn)).replaceAll(" ", "");

        int vowelCounter = 0;
        int otherCounter = 0;
        int punctuationCounter = 0;

        for (char character : input.toCharArray()) {
            if (vowels.contains(character)) {
                vowelCounter++;
            } else if (punctuationSymbols.contains(character)) {
                punctuationCounter++;
            } else {
                otherCounter++;
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathOut));
        bufferedWriter.write("Vowels:" + vowelCounter);
        bufferedWriter.newLine();
        bufferedWriter.write("Other symbols:" + otherCounter);
        bufferedWriter.newLine();
        bufferedWriter.write("Punctuation:" + punctuationCounter);
        bufferedWriter.close();
    }
}
