package Y_ExamPreparation.ExamPrep_09;

import java.util.*;
import java.util.stream.*;

public class E01_PiePursuit {

/*You will receive two sequences on two separate lines. Each sequence will consist of integer values, separated by a single whitespace.
The first sequence represents contestants, each value indicating the total count of pieces of pie a contestant can consume,
while the second sequence represents the pies, signifying the number of pieces each pie contains.
Contest Rules:
    •	The competition continues until no more pies are left or no more contestants remain in the battle
    •	The contest kicks off with the first contestant facing the last pie in the sequence
    •	If the contestant's pie-eating capacity is greater than or equal to the pie's size, they manage to eat the entire pie,
        subtracting the pie's value (count of pie pieces) from the contestant's value (pie-eating capacity).
        The pie is removed from the collection.
        o	If the contestant's pie-eating capacity reaches 0, bid them farewell from the contest (remove the contestant from the competition).
        o	Otherwise, move the satisfied contestant to the back of the lineup, with the remaining pie-eating capacity.
    •	If the pie's size exceeds the contestant's pie-eating capacity, the contestant consumes as many pieces as possible,
        subtracting the eaten pieces (contestant's capacity) from the pie's size.
        o	The pie remains in the sequence with the value of pieces left.
        o	If the pie's size reaches 1 piece, remove the pie, adding the remaining piece to the next pie in the sequence.
        o	If this is the last pie, be careful, you won’t be able to add a piece to the next pie.
            Just leave that last piece back in the sequence.
        o	Say goodbye to the contented contestant from the contest (remove the contestant from the competition).
    •	In the end:
        o	If the pies are over, and there are contestants left, print on the console: "We will have to wait for more pies to be baked!"
            and the final state of the contestants' sequence on a separate line.
        o	If both the pies and contestants are over, it means that we have a champion. Print on the console: "We have a champion!"
        o	If the contestants are over, but there are pies left, print on the console: "Our contestants need to rest!" and the final state of the pie sequence on a separate line.

Let the Pie Pursuit unfold and discover who will be the ultimate champion!

Input / Constraints:
    •	On the first line, you will receive the integers, representing the contestant's pie-eating capacity, separated by a single space.
    •	On the second line, you will receive the integers, representing the number of pieces each pie contains, separated by a single space.

Output:
    The following result should be printed on the Console, on separate lines:
        •	If the pies are over, and there are contestants left:
            o	"We will have to wait for more pies to be baked!"
            o	The final state of the contestants' sequence: "Contestants left: {contestant1}, {contestant2}, … {contestantN}"
        •	If both the pies and contestants are over:
            o	"We have a champion!"
        •	If the contestants are over, but there are pies left:
            o	"Our contestants need to rest!"
            o	The final state of the pie sequence
            o	"Pies left: {pie1}, {pie2}, … {pien}" */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> contestantsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> piesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(contestantsQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(piesStack::push);

        while (!contestantsQueue.isEmpty() && !piesStack.isEmpty()) {

            int contestant = contestantsQueue.poll();
            int pie = piesStack.pop();

            if (contestant >= pie) {
                contestant -= pie;
                if (contestant != 0) {
                    contestantsQueue.offer(contestant);
                }
            } else if (contestant < pie) {
                pie -= contestant;
                if (pie == 1) {
                    if (piesStack.size() > 0) {
                        int newPie = piesStack.pop();
                        newPie += pie;
                        piesStack.push(newPie);
                    } else {
                        piesStack.push(pie);
                    }
                } else {
                    piesStack.push(pie);
                }
            }
        }

        if (piesStack.isEmpty() && !contestantsQueue.isEmpty()) {
            String remainingContestants = contestantsQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("We will have to wait for more pies to be baked!");
            System.out.printf("Contestants left: %s", remainingContestants);
        } else if (piesStack.isEmpty() && contestantsQueue.isEmpty()) {
            System.out.println("We have a champion!");
        } else if (!piesStack.isEmpty() && contestantsQueue.isEmpty()) {
            String remainingPies = piesStack.reversed().stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Our contestants need to rest!");
            System.out.printf("Pies left: %s", remainingPies);
        }
    }
}