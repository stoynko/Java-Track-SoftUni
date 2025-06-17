package D_StreamFilesAndDirectories;

import java.io.*;
import java.util.*;

public class L04_ExtractIntegers {

/*Read the file provided, named "input.txt" and extracts all integers that are not a part of a word in a separate file.
A valid integer is surrounded by white spaces.*/

    public static void main(String[] args) throws FileNotFoundException {

        String pathIn = "src/C_Advanced/StreamFilesAndDirectories/resources/Lab/input.txt";
        String pathOut = "src/C_Advanced/StreamFilesAndDirectories/resources/Lab/04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(pathIn));
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(pathOut));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int integer = scanner.nextInt();
                printWriter.println(integer);
            }
            scanner.nextLine();
        }
        printWriter.close();
    }
}
