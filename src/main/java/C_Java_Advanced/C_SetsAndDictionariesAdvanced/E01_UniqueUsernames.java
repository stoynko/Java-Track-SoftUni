package C_Java_Advanced.C_SetsAndDictionariesAdvanced;

import java.util.*;

public class E01_UniqueUsernames {

/*Write a simple program that reads a sequence of usernames from the console and keeps a collection with only the unique ones.
Print the collection on the console in order of insertion.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        HashSet<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String username = scanner.nextLine();
            usernames.add(username);
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}


