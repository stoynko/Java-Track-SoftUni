package B_Java_Fundamentals.Y_FinalExam.ExamPrep_V04;

import java.util.*;

public class P01_TheImitationGame {

/*During World War 2, you are a mathematician who joined the cryptography team to decipher the enemy's enigma code. Your job is to create a program to crack the codes.
On the first line of the input, you will receive the encrypted message. After that, until the "Decode" command is given, you will be receiving strings with instructions for different operations
that need to be performed upon the concealed message to interpret it and reveal its true content. There are several types of instructions, split by '|'
    •	"Move {number of letters}":
        o	Moves the first n letters to the back of the string
    •	"Insert {index} {value}":
        o	Inserts the given value before the given index in the string
    •	"ChangeAll {substring} {replacement}":
        o	Changes all occurrences of the given substring with the replacement text
Input / Constraints:
    •	On the first line, you will receive a string with a message.
    •	On the following lines, you will be receiving commands, split by '|' .
Output:
    •	After the "Decode" command is received, print this message:
        "The decrypted message is: {message}"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder decodedMessage = new StringBuilder(input);

        while (!input.equals("Decode")) {

            String operation = input.split("\\|")[0];
            switch (operation) {
                case "Move" -> {
                    int numberOfLetters = Integer.parseInt(input.split("\\|")[1]);
                    String substring = decodedMessage.substring(0, numberOfLetters);
                    decodedMessage.delete(0, numberOfLetters);
                    decodedMessage.append(substring);
                }
                case "Insert" -> {
                    int index = Integer.parseInt(input.split("\\|")[1]);
                    String substring = input.split("\\|")[2];
                    decodedMessage.insert(index, substring);
                }
                case "ChangeAll" -> {
                    String substring = input.split("\\|")[1];
                    String replacement = input.split("\\|")[2];
                    String temp = decodedMessage.toString().replace(substring, replacement);
                    decodedMessage.replace(0, decodedMessage.length(), temp);
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s\n", decodedMessage);
    }
}
