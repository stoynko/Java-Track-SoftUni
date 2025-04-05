package B_Java_Fundamentals.Y_FinalExam.ExamPrep_V01;

import java.util.*;

public class P01_WorldTour {

/*You are a world traveler, and your next goal is to make a world tour. To do that, you have to plan out everything first.
To start with, you would like to plan out all of your stops where you will have a break.
On the first line, you will be given a string containing all of your stops. Until you receive the command "Travel",
you will be given some commands to manipulate that initial string. The commands can be:
•	"Add Stop:{index}:{string}":
        o	Insert the given string at that index only if the index is valid.
•	"Remove Stop:{start_index}:{end_index}":
        o	Remove the elements of the string from the starting index to the end index (inclusive) if both indices are valid.
•	"Switch:{old_string}:{new_string}":
        o	If the old string is in the initial string, replace it with the new one (all occurrences).

Note: After each command, print the current state of the string! After the "Travel" command, print the following: "Ready for world tour! Planned stops: {string}".

Input / Constraints:
•	JavaScript: you will receive a list of strings.
•	An index is valid if it is between the first and the last element index (inclusive) (0 ….. Nth) in the sequence.
Output:
•	Print the proper output messages in the proper cases as described in the problem description.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder(input);

        while (!input.equals("Travel")) {

            String[] commands = input.split(":");
            String command = commands[0];

            switch (command) {
                case "Add Stop" -> {
                    int index = Integer.parseInt(commands[1]);
                    String travelStop = commands[2];
                    if (checkIndex(text, index)) {
                        text.insert(index, travelStop);
                    }
                    System.out.println(text);
                }
                case "Remove Stop" -> {
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]) + 1;
                    if (checkIndex(text, startIndex) && checkIndex(text, endIndex)) {
                        text.delete(startIndex, endIndex);
                    }
                    System.out.println(text);
                }
                case "Switch" -> {
                    String oldString = commands[1];
                    String newString = commands[2];
                    String updatedText = text.toString().replaceAll(oldString, newString);
                    text.setLength(0);
                    text.append(updatedText);
                    System.out.println(text);
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", text);
    }

    private static boolean checkIndex(StringBuilder text, int index) {
        return index >= 0 && index <= text.length();
    }
}