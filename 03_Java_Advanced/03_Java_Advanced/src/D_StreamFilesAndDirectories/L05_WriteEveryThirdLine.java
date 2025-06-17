package D_StreamFilesAndDirectories;

import java.io.*;
import java.util.*;

public class L05_WriteEveryThirdLine {

//Read the file provided, named "input.txt" and write to another file all lines whose number is divisible by 3. Line numbers start from one.

    public static void main(String[] args) throws FileNotFoundException {

        String pathIn = "src/C_Advanced/StreamFilesAndDirectories/resources/Lab/input.txt";
        String pathOut = "src/C_Advanced/StreamFilesAndDirectories/resources/Lab/05.WriteEveryThirdLineOutput.txt";

        Scanner input = new Scanner(new FileReader(pathIn));
        PrintWriter output = new PrintWriter(pathOut);

        int counter = 1;
        String line = input.nextLine();
        while (input.hasNextLine()) {
            if (counter % 3 == 0) {
                output.println(line);
            }
            counter++;
            line = input.nextLine();
        }
        output.close();
    }
}
