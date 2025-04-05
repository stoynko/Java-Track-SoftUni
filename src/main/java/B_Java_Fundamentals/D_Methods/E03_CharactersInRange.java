package B_Java_Fundamentals.D_Methods;

import java.util.*;

public class E03_CharactersInRange {

/*Write a method that receives two characters and prints all the characters in between them on a single line according to ASCII.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char charA = (scanner.nextLine().charAt(0));
        char charB = (scanner.nextLine().charAt(0));
        System.out.println(getCurrentChar(charA, charB));
    }

    private static String getCurrentChar(char charA, char charB) {
        StringBuilder result = new StringBuilder();

        char charStart = (char) Math.min(charA, charB);
        char charEnd = (char) (Math.max(charA, charB));

        for (int index = charStart + 1; index < charEnd; index++) {
            result.append(String.valueOf((char) index)).append(" ");
        }
        return result.toString();
    }
}
