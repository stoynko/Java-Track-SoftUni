package Y_ExamPreparation.ExamPrep_06;

import java.util.*;
import java.util.stream.*;

public class E01_WildSurvival {

/*On the first line, you will be given a sequence containing integers representing bee groups that live in a beehive. On the second line,
you will be given another sequence of integers representing bee-eaters groups living near the beehive. Bees and bee-eaters are eternal enemies and are always fighting.
Bees are known as the defenders of their hive while the bee-eaters are known as the attackers.

Until there are bees and bee-eaters available, the program will continue running.
You need to compare the first group of bees to the last group of bee-eaters (See the Examples):
    •	They start a fight until at least one of the groups is defeated. One bee-eater can kill 7 (seven) bees at once, per each fight, then dies. If one attacker needs to fight
        fewer defenders in number (less than 7), it survives while the defenders are considered defeated. In the next battle, it can kill 7 (seven) defenders again.
        o	If the bee-eaters from the current fighting group win (there are 0 (zero) remaining bees in the corresponding group) return the survived bee-eaters to the sequence
            (in their initial position). The defeated bee group is removed.
        o	If the bees from the current fighting group win, (there are 0 (zero) remaining bee-eaters of the corresponding group) add the bees that survived to the back of the
            bees collection. The defeated group of bee-eaters is removed.
        o	If the result is a draw, remove both groups from their collections and proceed to the next ones.
Input / Constraints:
    •	On the first line, you will receive integers representing the bee groups, separated by a single space. (See the Examples)
    •	On the second line, you will receive integers representing the bee-eaters groups, separated by a single space. (See the Examples)
    •	The given numbers will be valid positive integers in the range [1 - 100] inclusive.
Output:
The output of your program should be printed on the Console, on separate lines, depending on the following outcome variations:
    •	On the first line: "The final battle is over!"
    •	On the second line:
        o	If bees and bee-eaters have slaughtered each other, print: "But no one made it out alive!"
        o	If there are bees that survived, print: "Bee groups left: {bee_group1, bee_group2, …, bee_groupN}".	Print the bee groups in their current order,
            separated by comma and space ", ".
        o	If there are bee-eater groups that have survived, print: "Bee-eater groups left: {bee_eaters_group1, …, bee_eaters_groupN}". Print the bee-eater groups in their
        current order, separated by comma and space ", ". */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> defendersQueue = new ArrayDeque<>();
        ArrayDeque<Integer> attackersStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(defendersQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(attackersStack::push);

        while (!defendersQueue.isEmpty() && !attackersStack.isEmpty()) {

            int defenders = defendersQueue.pop();
            int attackers = attackersStack.poll();

            if (attackers * 7 > defenders) {
                attackers -= (defenders / 7);
                attackersStack.push(attackers);
            } else if (defenders > attackers * 7) {
                defenders -= (attackers * 7);
                defendersQueue.offer(defenders);
            }
        }

        System.out.println("The final battle is over!");
        if (defendersQueue.isEmpty() && attackersStack.isEmpty()) {
            System.out.println("But no one made it out alive!");
        } else if (!defendersQueue.isEmpty()) {
            String remainingDefenders = defendersQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Bee groups left: %s\n", remainingDefenders);
        } else if (!attackersStack.isEmpty()) {
            String remainingAttackers = attackersStack.reversed().stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Bee-eater groups left: %s\n", String.join(", ", remainingAttackers));
        }
    }
}
