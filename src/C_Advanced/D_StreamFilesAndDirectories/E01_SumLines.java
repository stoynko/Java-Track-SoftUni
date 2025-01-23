package C_Advanced.D_StreamFilesAndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class E01_SumLines {

/*Write a program that reads a text file ("input.txt" from the Resources - Exercises) and prints on the console the sum of the ASCII symbols of each of its lines.
Use BufferedReader in combination with FileReader.*/

    public static void main(String[] args) throws IOException {

        String path = "src/C_Advanced/StreamFilesAndDirectories/resources/Exercise/input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        allLines.stream().map(String::toCharArray)
                .forEach(arr -> {
                    int sum = 0;
                    for (char character : arr) {
                        sum += character;
                    }
                    System.out.println(sum);
                });

    }
}
