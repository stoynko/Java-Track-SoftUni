package B_Java_Fundamentals.X_MidExam.ExamPrep_V06;

import java.util.*;
import java.util.stream.*;

public class P02_TreasureHunt {

/*The pirates need to carry a treasure chest safely back to the ship, looting along the way. Create a program that manages the state of the treasure chest along the way.
On the first line, you will receive the initial loot of the treasure chest, which is a string of items separated by a "|".

    "{loot1}|{loot2}|{loot3} … {lootN}"

The following lines represent commands until "Yohoho!" which ends the treasure hunt:
    • "Loot {item1} {item2}…{itemNN}":
        o   Pick up treasure loot along the way. Insert the items at the beginning of the chest.
        o   If an item is already contained, don't insert it.
    • "Drop {index}":
        o   Remove the loot at the given position and add it at the end of the treasure chest.
        o   If the index is invalid, skip the command.
    • "Steal {count}":
        o   Someone steals the last count of loot items. If there are fewer items than the given count, remove as many as there are.
        o   Print the stolen items separated by ", ": "{item1}, {item2}, {item3} … {itemN}"

In the end, output the average treasure gain, which is the sum of all treasure items' length divided by the count of all items inside the chest
formatted to the second decimal point: "Average treasure gain: {averageGain} pirate credits."

If the chest is empty, print the following message:
"Failed treasure hunt."

Input:
    • On the 1st line, you are going to receive the initial treasure chest (loot separated by "|").
    • On the following lines, until "Yohoho!", you will be receiving commands.
Output:
    • Print the output in the format described above.
Constraints:
    • The loot items will be strings containing any ASCII code.
    • The indexes will be integers in the range [-200…200]
    • The count will be an integer in the range [1….100]*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> treasure = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Yohoho!")) {
            List<String> actions = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String action = actions.get(0);

            switch (action) {

                case "Loot" -> {
                    actions.remove(0);
                    for (String item : actions) {
                        if (!treasure.contains(item)) {
                            treasure.add(0, item);
                        }
                    }
                }
                case "Drop" -> {
                    int index = Integer.parseInt(actions.get(1));
                    if (checkForValidIndex(treasure, index)) {
                        String item = treasure.get(index);
                        treasure.remove(index);
                        treasure.add(item);
                    }
                }
                case "Steal" -> {
                    List<String> stolenItems = new ArrayList<>();
                    int count = Integer.parseInt(actions.get(1));
                    if (treasure.size() < count) {
                        count = treasure.size();
                    }
                    while (count > 0) {
                        stolenItems.add(treasure.get(treasure.size() - 1));
                        treasure.remove(treasure.size() - 1);
                        count--;
                    }
                    Collections.reverse(stolenItems);
                    System.out.println(stolenItems.toString().replaceAll("[\\[\\]]", ""));
                }

            }

            input = scanner.nextLine();
        }
        if (treasure.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            int lengthSum = 0;
            for (String item : treasure) {
                lengthSum += item.length();
            }
            double averageTreasureGain = (double) lengthSum / treasure.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasureGain);
        }
    }

    private static boolean checkForValidIndex(List<String> list, int index) {
        return index >= 0 && index < list.size();
    }
}