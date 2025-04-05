package B_Java_Fundamentals.X_MidExam.ExamPrep_V03;

import java.util.*;
import java.util.stream.*;

public class P03_MovingTarget {

/*You are at the shooting gallery again, and you need a program that helps you keep track of moving targets.
On the first line, you will receive a sequence of targets with their integer values, split by a single space.
Then, you will start receiving commands for manipulating the targets until the "End" command. The commands are the following:

    •	"Shoot {index} {power}"
        o	Shoot the target at the index if it exists by reducing its value by the given power (integer value).
        o	Remove the target if it is shot. A target is considered shot when its value reaches 0.
    •	"Add {index} {value}"
        o	Insert a target with the received value at the received index if it exists.
        o	If not, print: "Invalid placement!"
    •	"Strike {index} {radius}"
        o	Remove the target at the given index and the ones before and after it depending on the radius.
        o	If any of the indices in the range is invalid, print: "Strike missed!" and skip this command.
    •	"End"
        o	Print the sequence with targets in the following format and end the program: "{target1}|{target2}…|{targetN}"

Input / Constraints:
    •	On the first line, you will receive the sequence of targets – integer values [1-10000].
    •	On the following lines, until the "End" will be receiving the command described above – strings.
    •	There will never be a case when the "Strike" command would empty the whole sequence.

Output:
    •	Print the appropriate message in case of any command if necessary.
    •	In the end, print the sequence of targets in the format described above.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] actions = input.split(" ");
            String action = actions[0];
            int index = Integer.parseInt(actions[1]);

            switch (action) {
                case "Shoot" -> {
                    if (checkForValidIndex(targets, index)) {
                        int power = Integer.parseInt(actions[2]);
                        int newTargetValue = targets.get(index) - power;
                        if (newTargetValue <= 0) {
                            targets.remove(index);
                        } else {
                            targets.set(index, newTargetValue);
                        }
                    }
                }
                case "Add" -> {
                    if (checkForValidIndex(targets, index)) {
                        int value = Integer.parseInt(actions[2]);
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                }
                case "Strike" -> {
                    if (checkForValidIndex(targets, index)) {
                        int radius = Integer.parseInt(actions[2]);
                        if (checkForValidIndex(targets, index - radius)) {
                            if (checkForValidIndex(targets, index + radius)) {
                                int targetsToShoot = (radius * 2) + 1;
                                int indexRadius = index - radius;
                                while (targetsToShoot > 0) {
                                    targets.remove(indexRadius);
                                    targetsToShoot--;
                                }
                            } else {
                                System.out.println("Strike missed!");
                            }
                        } else {
                            System.out.println("Strike missed!");
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(targets.toString().replaceAll(",", "|").replaceAll("[\\[\\] ]", ""));

    }

    private static boolean checkForValidIndex(List<Integer> list, int index) {
        return index >= 0 && index < list.size();
    }
}

