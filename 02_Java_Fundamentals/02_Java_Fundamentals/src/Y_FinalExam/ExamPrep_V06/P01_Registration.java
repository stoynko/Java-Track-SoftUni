package Y_FinalExam.ExamPrep_V06;

import java.util.*;

public class P01_Registration {

/*On the first line, you will receive the username that he wants to use in the first place. On the following lines, you will be receiving commands until the "Registration" command.
There are five possible commands:
    •	"Letters {Lower/Upper}"
        o	Replace all letters with lower case or with upper case, then print the result.
    •	"Reverse {startIndex} {endIndex}"
        o	Reverse the substring from the start index until the end index (both inclusive), then print it. Do NOT change it in the username.
                Note: Check if the indices are valid. If they aren't - skip the command. An index is valid when it is non-negative and less than the size of the collection.
    •	"Substring {substring}"
        o	If the username contains the given substring, cut it out and print the result without the cut substring.
        o	Otherwise, print:
        "The username {string} doesn't contain {substring}."
    •	"Replace {char}"
        o	Replace all occurences of the given char with a dash (-) and print the result.
    •	"IsValid {char}"
        o	For a username to be valid, it must contain the given char. If it is, print "Valid username.".
                o	Otherwise, print: "{char} must be contained in your username."
Input:
    •	On the first line, you are going to receive the string.

    •	On the following lines, until the "Registration" command is received, you will be receiving commands.
    •	All commands are case-sensitive.
Output:
    •	Print the output of every command in the format described above.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder userName = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Registration")) {

            String command = input.split("\\s+")[0];

            switch (command) {

                case "Letters" -> {
                    String action = input.split("\\s+")[1];
                    if (action.equals("Upper")) {
                        String temp = userName.toString().toUpperCase();
                        userName.setLength(0);
                        userName.append(temp);
                    } else if (action.equals("Lower")) {
                        String temp = userName.toString().toLowerCase();
                        userName.setLength(0);
                        userName.append(temp);
                    }
                    System.out.println(userName);
                }
                case "Reverse" -> {
                    int indexStart = Integer.parseInt(input.split("\\s+")[1]);
                    int indexEnd = Integer.parseInt(input.split("\\s+")[2]);
                    if (checkIndexValidity(indexStart, userName.toString()) && checkIndexValidity(indexEnd, userName.toString())) {
                        StringBuilder output = new StringBuilder(userName.substring(indexStart, indexEnd + 1)).reverse();
                        System.out.println(output);
                    }
                }
                case "Substring" -> {
                    String substring = input.split("\\s+")[1];
                    if (userName.toString().contains(substring)) {
                        String temp = userName.toString().replace(substring, "");
                        userName.setLength(0);
                        userName.append(temp);
                        System.out.println(userName);
                    } else {
                        System.out.printf("The username %s doesn't contain %s.\n", userName, substring);
                    }
                }
                case "Replace" -> {
                    char targetedChar = input.split("\\s+")[1].charAt(0);
                    String temp = userName.toString().replace(targetedChar, '-');
                    userName.setLength(0);
                    userName.append(temp);
                    System.out.println(userName);
                }
                case "IsValid" -> {
                    char targetedChar = input.split("\\s+")[1].charAt(0);
                    if (userName.toString().contains(String.valueOf(targetedChar))) {
                        System.out.println("Valid username.");
                    } else {
                        System.out.printf("%c must be contained in your username.\n", targetedChar);
                    }
                }
            }
            input = scanner.nextLine();
        }
    }

    private static boolean checkIndexValidity(int index, String text) {
        return index >= 0 && index <= text.length() - 1;
    }
}
