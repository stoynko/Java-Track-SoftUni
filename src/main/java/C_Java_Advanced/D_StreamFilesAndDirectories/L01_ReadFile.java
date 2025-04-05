package C_Java_Advanced.D_StreamFilesAndDirectories;

import java.io.*;

public class L01_ReadFile {

/*You are given a file named "input.txt". Read and print all of its contents as a sequence of bytes
(the binary representation of the ASCII code for each character) separated by a single comma.*/

    public static void main(String[] args) {

        String path = "src/C_Advanced/StreamFilesAndDirectories/resources/Lab/input.txt";
        try (InputStream input = new FileInputStream(path)) {
            int oneByte = input.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = input.read();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
