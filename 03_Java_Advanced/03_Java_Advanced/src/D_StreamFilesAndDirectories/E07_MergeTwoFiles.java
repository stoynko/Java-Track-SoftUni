package D_StreamFilesAndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class E07_MergeTwoFiles {

/*Write a program that reads the contents of two text files
("inputOne.txt", "inputTwo.txt" from Resources - Exercises) and merges them into a third one.*/

    public static void main(String[] args) throws IOException {

        String pathInFileA = "src/C_Advanced/StreamFilesAndDirectories/resources/Exercise/inputOne.txt";
        String pathInFileB = "src/C_Advanced/StreamFilesAndDirectories/resources/Exercise/inputTwo.txt";
        String pathOut = "src/C_Advanced/StreamFilesAndDirectories/resources/Exercise/output.txt";

        PrintWriter printWriter = new PrintWriter(pathOut);
        List<String> linesFileA = Files.readAllLines(Path.of(pathInFileA));
        List<String> linesFileB = Files.readAllLines(Path.of(pathInFileB));
        linesFileA.forEach(printWriter::println);
        linesFileB.forEach(printWriter::println);
        printWriter.close();
    }
}
