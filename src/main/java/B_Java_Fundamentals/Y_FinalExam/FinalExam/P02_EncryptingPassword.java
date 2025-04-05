package B_Java_Fundamentals.Y_FinalExam.FinalExam;

import java.util.*;
import java.util.regex.*;

public class P02_EncryptingPassword {

/*Create a program, that checks if inputs are a valid password and encrypt it. On the first line you will receive a number that indicates how many inputs you will receive on the next lines.
A password is valid when:
    •	It starts with a group of  symbols and ends with the same symbols (the same length) - All symbols are possible
    •	There is a greater than sign (">") after the first group and a less than sign ("<") before the last one
    •	In between the greater than sign and the less than sign there are four groups (each of three characters), separated by pipe ("|")
        o	The first group consists only of numbers
        o	The second group – only lower case letters
        o	The third one – only upper case letters
        o	The fourth one – all symbols except "<" and ">"
Example for a valid message: "$$$>312|dfe|KFE|@!#<$$$"

You must check if the password is valid and if it is - encrypt it, if it isn’t - print the following message: "Try another password!"
Encrypting a password means to take all numbers, letters and symbols from the middle four groups and concatenatе them. After successful encrypt, print it in the following format:
"Password: {encrypted password}"

Input:
•	On the first line - n - the count of inputs.
•	On the next n lines - input that you have to check if it has a valid password.

Output:
•	Print all results from each input, each on a new line.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int inputCount = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("^([\\w|\\W|\\S|\\d|\\D|]+)[>](?<passwordBody>[\\d]{3}[|][a-z]{3}[|][A-Z]{3}[^<>]{3,})[<]\\1");

        for (int currentInput = 1; currentInput <= inputCount; currentInput++) {
            Matcher matcher = pattern.matcher(scanner.nextLine());
            if (matcher.find()) {
                String passwordBody = matcher.group("passwordBody").replaceAll("\\|", "");
                System.out.printf("Password: %s\n", passwordBody);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}