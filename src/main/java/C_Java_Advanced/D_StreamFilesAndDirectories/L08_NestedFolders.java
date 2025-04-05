package C_Java_Advanced.D_StreamFilesAndDirectories;

import java.io.*;
import java.util.*;

public class L08_NestedFolders {

/*You are provided a folder named "Files-and-Streams". Create a program that lists the names of all directories in it
(including all nested directories). On the last line, print the count of all folders, including the root folder.*/

    public static void main(String[] args) {

        String path = "src/C_Advanced/StreamFilesAndDirectories/resources/Lab/Files-and-Streams";

        File root = new File(path);
        int count = 0;
        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            File file = queue.poll();
            File[] files = file.listFiles();
            System.out.printf("%s\n", file.getName());
            count++;
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        queue.offer(f);
                    }
                }
            }
        }
        System.out.printf("%d folders", count);
    }
}
