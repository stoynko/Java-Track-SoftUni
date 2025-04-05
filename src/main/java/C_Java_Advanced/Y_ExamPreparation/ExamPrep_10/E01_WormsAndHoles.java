package C_Java_Advanced.Y_ExamPreparation.ExamPrep_10;

import java.util.*;
import java.util.stream.*;

public class E01_WormsAndHoles {

/*The first line will give you a sequence of integers representing worms. Afterwards, you will be given another sequence of integers representing holes.
You have to start with the last worm and try to match it with the first hole.
    •	If their values are equal, the worm fits the hole and can get into it. After that, you should remove both of them from their sequences.
        Otherwise, you should remove the hole and decrease the value of the worm by 3.
    •	If the worm value becomes equal to or below 0, remove it from the sequence before trying to match it with the hole.
You need to stop matching when you have no more worms or holes.

Input / Constraints:
    •	On the first line, you will receive the integers, representing the worm size, separated by a single space.
    •	On the second line, you will receive the integers, representing the hole size, separated by a single space.
    •	All given numbers will be valid integers in the range [1, 50].

Output:
    •	On the first line:
        o	If there are matches print the following: "Matches: {matchesCount}"
        o	If there are no matches print the following: "There are no matches."
    •	On the second line print:
        o	If there are no worms left and all of them fit a hole: "Every worm found a suitable hole!"
        o	If there are no worms left but only some of them fit a hole: "Worms left: none"
        o	If there are worms left: "Worms left: {worm1}, {worm2}, (…),{wormN}"
    •	On the third line print:
        o	If there are no holes left: "Holes left: none"
        o	If there are holes left: "Holes left: {hole1}, {hole2}, (…),{holeN}" */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> wormsStack = new ArrayDeque<>();
        ArrayDeque<Integer> holesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(wormsStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(holesQueue::offer);
        int matchesCount = 0;
        int wormsCount = wormsStack.size();

        while (!holesQueue.isEmpty() && !wormsStack.isEmpty()) {
            int wormSize = wormsStack.pop();
            int holeSize = holesQueue.poll();

            if (wormSize == holeSize) {
                matchesCount++;
            } else {
                wormSize -= 3;
                if (wormSize > 0) {
                    wormsStack.push(wormSize);
                }
            }
        }

        System.out.println(matchesCount != 0 ? String.format("Matches: %d", matchesCount) : "There are no matches.");

        if (wormsStack.isEmpty() && matchesCount == wormsCount) {
            System.out.println("Every worm found a suitable hole!");
        } else if (wormsStack.isEmpty() && matchesCount != wormsCount) {
            System.out.println("Worms left: none");
        } else if (!wormsStack.isEmpty()) {
            String leftWorms = wormsStack.reversed().stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Worms left: %s\n", leftWorms);
        }

        if (holesQueue.isEmpty()) {
            System.out.println("Holes left: none");
        } else if (!holesQueue.isEmpty()) {
            String leftHoles = holesQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Holes left: %s\n", leftHoles);
        }
    }
}
