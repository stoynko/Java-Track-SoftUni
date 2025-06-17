package X_MidExam.ExamPrep_V01;

import java.util.*;
import java.util.stream.*;

public class P03_MemoryGame {

/*Write a program that recreates the Memory game.
On the first line, you will receive a sequence of elements. Each element in the sequence will have a twin. Until the player receives "end" from the console,
you will receive strings with two integers separated by a space, representing the indexes of elements in the sequence. If the player tries to cheat and enters two equal indexes
or indexes which are out of bounds of the sequence, you should add two matching elements at the middle of the sequence in the following format:

"-{number of moves until now}a"

Then print this message on the console:
"Invalid input! Adding additional elements to the board"

Input:
    •	On the first line, you will receive a sequence of elements.
    •	On the following lines, you will receive integers until the command "end".
Output:
    •	Every time the player hit two matching elements, you should remove them from the sequence and print on the console the following message:
"Congrats! You have found matching elements - ${element}!"
    •	If the player hit two different elements, you should print on the console the following message:
"Try again!"
    •	If the player hit all matching elements before he receives "end" from the console, you should print on the console the following message:
"You have won in {number of moves until now} turns!"
    •	If the player receives "end" before he hits all matching elements, you should print on the console the following message:
        "Sorry you lose :(
        {the current sequence's state}"

Constraints:
    •	All elements in the sequence will always have a matching element.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        int moves = 0;
        while (!input.equals("end")) {

            List<Integer> elementsIndex = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int index1 = elementsIndex.get(0);
            int index2 = elementsIndex.get(1);
            moves++;
            if (isIndexWithinListRange(elements, index1, index2)) {
                if (checkIfElementsMatch(elements, index1, index2)) {
                    String matchingElement = elements.get(index1);
                    System.out.printf("Congrats! You have found matching elements - %s!%n", matchingElement);
                    elements.remove(Math.max(index1, index2));
                    elements.remove(Math.min(index1, index2));
                    if (elements.isEmpty()) {
                        System.out.printf("You have won in %d turns!", moves);
                        return;
                    }
                } else {
                    System.out.println("Try again!");
                }

            } else {
                System.out.println("Invalid input! Adding additional elements to the board");
                int middleIndex = elements.size() / 2;
                String newElement = "-" + moves + "a";
                elements.add(middleIndex, newElement);
                elements.add(middleIndex + 1, newElement);
            }

            input = scanner.nextLine();
        }
        System.out.println("Sorry you lose :(");
        System.out.println(String.join(" ", elements));
    }

    private static boolean checkIfElementsMatch(List<String> list, int index1, int index2) {
        return (list.get(index1).equals(list.get(index2)));
    }

    public static boolean isIndexWithinListRange(List<String> list, int index1, int index2) {
        return (index1 >= 0) && (index1 < list.size()) && (index2 >= 0) && (index2 < list.size()) && (index1 != index2);
    }
}
