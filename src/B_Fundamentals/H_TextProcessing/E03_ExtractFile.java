package B_Fundamentals.H_TextProcessing;

import java.util.*;

public class E03_ExtractFile {

//Write a program that reads the path to a file and subtracts the file name and its extension. C:\Internal\training-internal\Template.pptx

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] path = Arrays.stream(scanner.nextLine().split("\\\\")).toArray(String[]::new);
        String fileName = path[path.length - 1].split("\\.")[0];
        String fileExtension = path[path.length - 1].split("\\.")[1];

        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s%n", fileExtension);
    }
}