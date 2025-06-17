package Y_ExamPreparation.ExamPrep_05;

import java.util.*;
import java.util.stream.*;

public class E01_BallGame {

/*On the first line, you will be given a sequence of integers representing the values of strength required to kick the ball.
In the next line, you will be given another sequence of integers representing the values of accuracy needed to direct the ball.

Until there are strengths and accuracies available, the program continues running.
You need to sum the last strength and the first accuracy then compare the result(see the Examples section):
    •	If the sum of the strength and the accuracy is equal to 100, there is a goal:
            o	Remove both values (the strength and the accuracy) from their sequences.
            o	You should keep track of the scored goals in total:
                -   Increase total scored goals by 1 (one).
    •	If the  sum of the strength and the accuracy is less than 100:
        o	If the value of the strength is smaller than the value of the accuracy:
            -   Remove the value of the strength from the sequence.
        o	If the value of the strength is greater than the value of the accuracy:
            -   Remove the value of the accuracy from the sequence.
        o	If both values are equal (strength = accuracy):
            -   Sum the strength and accuracy values (strength + accuracy). Return the summation result to the strength sequence (at its initial position).
            -   Remove the accuracy.
    •	If the  sum of the strength and the accuracy is greater than 100:
        o	Decrease the strength value by 10. Return it to the strength sequence (at its initial position).
        o	Move the accuracy value to the end of the accuracy sequence.

Input / Constraints:
    •	On the first line, you will receive integers representing the values of the strength, separated by a single space.
    •	On the second line, you will receive integers representing the values of the accuracy, separated by a single space.
    •	The size of the two sequences may differ.
    •	All given numbers will be valid integers in the range [10 - 90] and are divisible only by 10.

Output:
The output of your program should be printed on the Console, on separate lines, formatted according to the following rules:
    •	If Paul succeeded in scoring of exactly 3 (three) goals:
        o	"Paul scored a hat-trick!"
    •	If Paul failed to score a single goal:
        o	"Paul failed to score a single goal."
    •	If Paul scored more than 3 (three) goals:
        o	"Paul performed remarkably well!"
    •	If Paul scored more than 0 (zero) but less than 3 (three) goals:
        o	"Paul failed to make a hat-trick."
    •	Finally, print the total goals scored by Paul if there are any:
        o	"Goals scored: {total goals}"

    •	At the end of the program:
        o	If there are any values in the strength sequence, print:
            -   "Strength values left: {strength1}, {strength2}, (…),{strengthN}"
        o	If there are any values in the accuracy sequence, print:
            -   "Accuracy values left: {accuracy1}, {accuracy2}, (…),{accuracyN}"
        o	If there are no values in one or both sequences, skip the printing. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> strengthStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(strengthStack::push);
        ArrayDeque<Integer> accuracyQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(accuracyQueue::offer);
        int goalsScored = 0;

        while (!strengthStack.isEmpty() && !accuracyQueue.isEmpty()) {

            int strength = strengthStack.pop();
            int accuracy = accuracyQueue.poll();

            if (strength + accuracy > 100) {
                if (strength - 10 > 0) {
                    strengthStack.push(strength - 10);
                }
                accuracyQueue.offer(accuracy);
            } else if (strength + accuracy < 100) {
                if (strength < accuracy) {
                    accuracyQueue.offer(accuracy);
                } else if (strength > accuracy) {
                    strengthStack.push(strength);
                } else {
                    strengthStack.push(strength + accuracy);
                }
            } else {
                goalsScored++;
            }
        }

        if (goalsScored == 0) {
            System.out.println("Paul failed to score a single goal.");
        } else if (goalsScored > 0 && goalsScored < 3) {
            System.out.println("Paul failed to make a hat-trick.");
            System.out.printf("Goals scored: %d\n", goalsScored);
        } else if (goalsScored == 3) {
            System.out.println("Paul scored a hat-trick!");
            System.out.printf("Goals scored: %d\n", goalsScored);
        } else {
            System.out.println("Paul performed remarkably well!");
            System.out.printf("Goals scored: %d\n", goalsScored);
        }

        if (!strengthStack.isEmpty()) {
            String remainingValues = new ArrayList<>(strengthStack).reversed()
                    .stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Strength values left: " + remainingValues);
        }
        if (!accuracyQueue.isEmpty()) {
            String remainingValues = accuracyQueue.stream().map(String::valueOf).sorted().collect(Collectors.joining(", "));
            System.out.println("Accuracy values left: " + remainingValues);
        }
    }
}
