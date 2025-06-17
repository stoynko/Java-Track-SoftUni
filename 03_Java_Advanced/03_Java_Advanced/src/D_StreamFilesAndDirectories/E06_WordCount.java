package D_StreamFilesAndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class E06_WordCount {

/*Write a program that reads a list of words from the file "words.txt" (from the Resources - Exercises) and finds how many times each of the words is contained in another file "text.txt"
(from the Resources - Exercises). Matching should be case-insensitive. Write the results in the file "results.txt". Sort the words by frequency in descending order.*/

    public static void main(String[] args) throws IOException {

        String pathInA = "src/C_Advanced/StreamFilesAndDirectories/resources/Exercise/words.txt";
        String pathInB = "src/C_Advanced/StreamFilesAndDirectories/resources/Exercise/text.txt";
        String pathOut = "src/C_Advanced/StreamFilesAndDirectories/resources/Exercise/output.txt";

        List<String> wordsLines = Files.readAllLines(Path.of(pathInA));
        HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();

        for (String line : wordsLines) {
            Arrays.stream(line.split("\\s+")).forEach(word -> {
                wordsMap.put(word, 0);
            });
        }

        List<String> textLines = Files.readAllLines(Path.of(pathInB));

        for (String line : textLines) {
            Arrays.stream(line.split("\\s+")).forEach(word -> {
                if (wordsMap.containsKey(word)) {
                    wordsMap.put(word, wordsMap.get(word) + 1);
                }
            });
        }

        PrintWriter writer = new PrintWriter(pathOut);
        wordsMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();

    }

}
