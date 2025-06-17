package H_TextProcessing;

import java.util.*;

public class E04_CaesarCipher {

/*Write a program that returns an encrypted version of the same text.
Encrypt the text by shifting each character with three positions forward.
For example, A would be replaced by D, B would become E, and so on. Print the encrypted text.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder encryptedText = new StringBuilder();

        for (char currentChar : text.toCharArray()) {
            char encryptedChar = (char) (currentChar + 3);
            encryptedText.append(encryptedChar);
        }
        System.out.println(encryptedText);

    }
}
