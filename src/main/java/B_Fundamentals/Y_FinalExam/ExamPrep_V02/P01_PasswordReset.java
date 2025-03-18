package B_Fundamentals.Y_FinalExam.ExamPrep_V02;

import java.util.*;

public class P01_PasswordReset {

/*Write a password reset program that performs a series of commands upon a predefined string. First, you will receive a string, and afterward, until the command "Done" is given,
you will be receiving strings with commands split by a single space. The commands will be the following:
    •	"TakeOdd"
        o	 Takes only the characters at odd indices and concatenates them to obtain the new raw password and then prints it.
    •	"Cut {index} {length}"
        o	Gets the substring with the given length starting from the given index from the password and removes its first occurrence, then prints the password on the console.
        o	The given index and the length will always be valid.
    •	"Substitute {substring} {substitute}"
        o	If the raw password contains the given substring, replace all of its occurrences with the substitute text given and print the result.
                o	If it doesn't, prints "Nothing to replace!".
Input:
    •	You will be receiving strings until the "Done" command is given.
Output:
    •	After the "Done" command is received, print:
        o	"Your password is: {password}"
Constraints:
    •	The indexes from the "Cut {index} {length}" command will always be valid.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder password = new StringBuilder(text);
        String input = scanner.nextLine();

        while (!input.equals("Done")) {

            String command = input.split("\\s+")[0];

            switch (command) {

                case "TakeOdd" -> {
                    StringBuilder temp = new StringBuilder();
                    for (int index = 1; index <= password.length() - 1; index += 2) {
                        temp.append(password.charAt(index));
                    }
                    password.setLength(0);
                    password.append(temp);
                    System.out.println(password);
                }
                case "Cut" -> {
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    int length = Integer.parseInt(input.split("\\s+")[2]);
                    password.replace(index, index + length, "");
                    System.out.println(password);
                }
                case "Substitute" -> {
                    String substring = input.split("\\s+")[1];
                    String replacement = input.split("\\s+")[2];
                    if (password.toString().contains(substring)) {
                        String temp = password.toString().replaceAll(substring, replacement);
                        password.setLength(0);
                        password.append(temp);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s\n", password);
    }
}
