package Y_FinalExam.ExamPrep_V05;

import java.util.*;

public class P01_SecretChat {

/*On the first line of the input, you will receive the concealed message. After that, until the "Reveal" command is given, you will receive strings with instructions for different operations
that need to be performed upon the concealed message to interpret it and reveal its actual content. There are several types of instructions, split by ":|:"

    •	"InsertSpace:|:{index}":
        o	Inserts a single space at the given index. The given index will always be valid.
    •	"Reverse:|:{substring}":
        o	If the message contains the given substring, cut it out, reverse it and add it at the end of the message.
        o	If not, print "error".
                o	This operation should replace only the first occurrence of the given substring if there are two or more occurrences.
    •	"ChangeAll:|:{substring}:|:{replacement}":
        o	Changes all occurrences of the given substring with the replacement text.

Input / Constraints:
    •	On the first line, you will receive a string with a message.
    •	On the following lines, you will be receiving commands, split by ":|:".

Output:
    •	After each set of instructions, print the resulting string.
    •	After the "Reveal" command is received, print this message:
        "You have a new text message: {message}"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] commands = input.split(":\\|:");
            String command = commands[0];

            switch (command) {
                case "InsertSpace" -> {
                    int index = Integer.parseInt(commands[1]);
                    message.insert(index, " ");
                    System.out.println(message);
                }
                case "Reverse" -> {
                    StringBuilder substring = new StringBuilder(commands[1]);
                    if (message.toString().contains(substring)) {
                        int indexStart = message.indexOf(substring.toString());
                        int indexEnd = indexStart + substring.length();
                        message.replace(indexStart, indexEnd, "");
                        message.append(substring.reverse());
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                }
                case "ChangeAll" -> {
                    String substring = commands[1];
                    String replacement = commands[2];
                    String temp = message.toString().replaceAll(substring, replacement);
                    message.setLength(0);
                    message.append(temp);
                    System.out.println(message);
                }

            }
            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s\n", message);
    }
}
