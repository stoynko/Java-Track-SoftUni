package C_Java_Advanced.D_StreamFilesAndDirectories;

import java.io.*;
import java.nio.file.*;

public class E03_AllCapitals {

//Write a program that reads a text file ("input.txt" from the Resources - Exercises) and changes the casing of all letters to the upper. Write the output to another file ("output.txt").

    public static void main(String[] args) throws IOException {

        String path = "src/C_Advanced/StreamFilesAndDirectories/resources/Exercise/input.txt";

        String lowercaseString = Files.readString(Path.of(path));
        String uppercaseString = lowercaseString.toUpperCase();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/C_Advanced/StreamFilesAndDirectories/resources/Exercise/output.txt"));
        bufferedWriter.write(uppercaseString);
        bufferedWriter.close();
    }
}
