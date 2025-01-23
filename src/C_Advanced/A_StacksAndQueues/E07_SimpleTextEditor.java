package C_Advanced.A_StacksAndQueues;

import java.util.*;

public class E07_SimpleTextEditor {

/*You are given an empty text. Your task is to implement 4 types of commands related to manipulating the text:
    •	"1 {string}" - appends [string] to the end of the text.
    •	"2 {count}" - erases the last [count] elements from the text.
    •	"3 {index}" - returns the element at position [index] from the text.
    •	"4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation.

Input
    •	The first line contains N, the number of operations, where 1 ≤ N ≤ 105.
    •	Each of the following N lines contains the name of the operation, followed by the command argument, if any,
separated by space in the following format "command argument".
    •	The length of the text will not exceed 1000000.
    •	All input characters are English letters.
    •	It is guaranteed that the sequence of input operations is possible to perform.

    Output
•	For each operation of type "3" print a single line with the returned character of that operation.*/

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int numOfOperations = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> memory = new ArrayDeque<>();

        for (int currentOperation = 1; currentOperation <= numOfOperations; currentOperation++) {

            String[] commands = scanner.nextLine().split("\\s+");

            switch (commands[0]) {
                case "1" -> {
                    memory.push(text.toString());
                    String textToAppend = commands[1];
                    text.append(textToAppend);
                }
                case "2" -> {
                    memory.push(text.toString());
                    int charsToDelete = Integer.parseInt(commands[1]);
                    int endIndex = text.length();
                    int startIndex = Math.max(endIndex - charsToDelete, 0);
                    text = new StringBuilder(text.delete(startIndex, endIndex));
                }
                case "3" -> {
                    int index = Integer.parseInt(commands[1]);
                    System.out.println(text.charAt(index - 1));
                }
                case "4" -> {
                    text = new StringBuilder(memory.pop());
                }
            }
        }

    }
}