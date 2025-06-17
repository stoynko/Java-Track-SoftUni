package H_TextProcessing;

import java.util.*;

public class E01_ValidUsernames {

/*Write a program that reads usernames on a single line (joined by ", ") and prints all valid usernames. A valid username is:
    •	Has a length of between 3 and 16 characters.
    •	It contains only letters, numbers, hyphens, and underscores.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");
        for (String username : usernames) {
            if (checkIfValid(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean checkIfValid(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }
        for (char currentChar : username.toCharArray()) {
            if (!Character.isLetterOrDigit(currentChar) && currentChar != '-' && currentChar != '_') {
                return false;
            }
        }
        return true;
    }
}