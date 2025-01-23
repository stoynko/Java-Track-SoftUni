package C_Advanced.D_StreamFilesAndDirectories;

import java.io.*;

public class E02_SumBytes {

/*Write a program that reads a text file ("input.txt" from the Resources - Exercises) and prints on the console the sum of the ASCII symbols of all characters inside the file.
Use BufferedReader in combination with FileReader.*/

    public static void main(String[] args) throws IOException {

        String path = "src/C_Advanced/StreamFilesAndDirectories/resources/Exercise/input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();

        int sum = 0;
        while (line != null) {

            for (char character : line.toCharArray()) {
                sum += character;
            }

            line = bufferedReader.readLine();
        }
        System.out.println(sum);
    }
}
