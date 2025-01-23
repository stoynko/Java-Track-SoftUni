package C_Advanced.D_StreamFilesAndDirectories;

import java.io.*;

public class L07_ListFiles {

/*You are provided a folder named "Files-and-Streams". Create a program that lists the names and file sizes (in bytes) of all files
that are placed directly in it (do not include files in nested folders).*/

    public static void main(String[] args) {

        String path = "src/C_Advanced/StreamFilesAndDirectories/resources/Lab/Files-and-Streams";

        File file = new File(path);

        if (file.exists()) {

            if(file.isDirectory()){
                File[] files = file.listFiles();
                for(File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]\n", f.getName(), f.length());
                    }
                }
            }
        }

    }
}
