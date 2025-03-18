package C_Advanced.D_StreamFilesAndDirectories;

import java.io.*;

public class L03_CopyBytes {

/*Read the file named "input.txt" and write to another file every character's ASCII representation.
Write every space or new line as it is, e.g., a space or a new line.*/

    public static void main(String[] args) throws IOException {

        String pathIn = "src/C_Advanced/StreamFilesAndDirectories/resources/Lab/input.txt";
        String pathOut = "src/C_Advanced/StreamFilesAndDirectories/resources/Lab/03.CopyBytesOutput.txt";

        FileInputStream inputStream = new FileInputStream(pathIn);
        FileOutputStream outputStream = new FileOutputStream(pathOut);

        int oneByte = inputStream.read();

        while (oneByte >= 0) {
            if (oneByte == 32 || oneByte == 10) {
                outputStream.write(oneByte);
            } else {
                String digits = String.valueOf(oneByte);
                for (int i = 0; i < digits.length()  ; i++) {
                    outputStream.write(digits.charAt(i));
                }
            }
            oneByte = inputStream.read();
        }
        outputStream.close();

    }
}
