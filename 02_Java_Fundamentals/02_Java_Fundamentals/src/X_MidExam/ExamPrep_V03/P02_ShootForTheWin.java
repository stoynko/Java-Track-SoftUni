package X_MidExam.ExamPrep_V03;

import java.util.*;
import java.util.stream.*;

public class P02_ShootForTheWin {

/*Write a program that helps you keep track of your shot targets. You will receive a sequence with integers, separated by a single space, representing targets and their value.
Afterward, you will be receiving indices until the "End" command is given, and you need to print the targets and the count of shot targets.
Every time you receive an index, you need to shoot the target on that index, if it is possible.
Every time you shoot a target, its value becomes -1, and it is considered a shot. Along with that, you also need to:
    •	Reduce all the other targets, which have greater values than your current target, with its value.
    •	Increase all the other targets, which have less than or equal value to the shot target, with its value.
Keep in mind that you can't shoot a target, which is already shot. You also can't increase or reduce a target, which is considered a shot.
When you receive the "End" command, print the targets in their current state and the count of shot targets in the following format:
    "Shot targets: {count} -> {target1} {target2}… {targetN}"

Input / Constraints:
    •	On the first line of input, you will receive a sequence of integers, separated by a single space – the targets sequence.
    •	On the following lines, until the "End" command, you be receiving integers each on a single line – the index of the target to be shot.
Output:
    •	The format of the output is described above in the problem description.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        int shotTargets = 0;

        while (!input.equals("End")) {

            int indexCurrentTarget = Integer.parseInt(input);
            int currentTargetValue = 0;
            if (indexCurrentTarget >= 0 && indexCurrentTarget < targets.size()) {
                currentTargetValue = targets.get(indexCurrentTarget);
                targets.set(indexCurrentTarget, -1);
                shotTargets++;
                modifyTargets(targets, indexCurrentTarget, currentTargetValue);
            }

            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", shotTargets);
        System.out.println(targets.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void modifyTargets(List<Integer> targets, int indexCurrentTarget, int currentTargetValue) {
        for (int index = 0; index < targets.size(); index++) {

            int currentElement = targets.get(index);
            if (currentElement > currentTargetValue) {
                currentElement -= currentTargetValue;
            } else if (currentTargetValue >= currentElement) {
                if (currentElement == -1) {
                    continue;
                }
                currentElement += currentTargetValue;
            }
            targets.set(index, currentElement);
        }
    }
}