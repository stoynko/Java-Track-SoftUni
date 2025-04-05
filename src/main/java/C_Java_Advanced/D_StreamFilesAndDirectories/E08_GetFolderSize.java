package C_Java_Advanced.D_StreamFilesAndDirectories;

import java.io.*;

public class E08_GetFolderSize {

//Write a program that traverses a folder and calculates its size in bytes. Use Folder Exercises Resources in Resources.

    public static void main(String[] args) {

        String path = "src/C_Advanced/StreamFilesAndDirectories/resources/Exercise";
        File folder = new File(path);
        File[] allFiles = folder.listFiles();

        int folderSize = 0;
        for (File file : allFiles) {
            folderSize += (int) file.length();
        }

        System.out.printf("Folder size: %d", folderSize);
    }
}
