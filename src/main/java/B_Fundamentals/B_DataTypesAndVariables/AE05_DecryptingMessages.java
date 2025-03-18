package B_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class AE05_DecryptingMessages {

/*You will receive a key (integer) and n characters afterward. Add the key to each character and append them to the message.
In the end, print the message, which you decrypted.

    •	On the first line, you will receive the key.
    •	On the second line, you will receive n – the number of lines that will follow.
    •	On the next n lines – you will receive lower and uppercase characters from the Latin alphabet.

Print the decrypted message.

Constraints:
    •	The key will be in the interval [0…20].
    •	n will be in the interval [1…20].
    •	The characters will always be upper or lower-case letters from the English alphabet.
    •	You will receive one letter per line.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte key = Byte.parseByte(scanner.nextLine());
        byte inputCount = Byte.parseByte(scanner.nextLine());
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 1; i <= inputCount; i++) {

            char currentChar = scanner.next().charAt(0);
            byte ASCII = (byte) currentChar;
            char newChar = (char) ((byte) (key + ASCII));
            decryptedMessage.append(newChar);
        }
        System.out.println(decryptedMessage);
    }
}