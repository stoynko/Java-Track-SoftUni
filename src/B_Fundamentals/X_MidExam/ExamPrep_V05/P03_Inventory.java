package B_Fundamentals.X_MidExam.ExamPrep_V05;

import java.util.*;
import java.util.stream.*;

public class P03_Inventory {

/*As a young traveler, you gather items and craft new items.

Input / Constraints:

You will receive a journal with some collecting items, separated with a comma and a space (", ").
After that, until receiving "Craft!" you will be receiving different commands split by " - ":
    •	"Collect - {item}" - you should add the given item to your inventory. If the item already exists, you should skip this line.
    •	"Drop - {item}" - you should remove the item from your inventory if it exists.
    •	"Combine Items - {old_item}:{new_item}" - you should check if the old item exists. If so, add the new item after the old one. Otherwise, ignore the command.
    •	"Renew – {item}" – if the given item exists, you should change its position and put it last in your inventory.

Output:
After receiving "Craft!" print the items in your inventory, separated by ", ".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {

            String[] actions = input.split(" - ");
            String action = actions[0];
            String item = actions[1];
            switch (action) {
                case "Collect" -> {
                    if (!items.contains(item)) {
                        items.add(item);
                    }
                }
                case "Drop" -> {
                    if (items.contains(item)) {
                        items.remove(item);
                    }
                }
                case "Combine Items" -> {
                    String[] itemsToCombine = actions[1].split(":");
                    String oldItem = itemsToCombine[0];
                    String newItem = itemsToCombine[1];

                    if (items.contains(oldItem)) {
                        items.add(items.indexOf(oldItem) + 1, newItem);
                    }
                }
                case "Renew" -> {
                    if (items.contains(item)) {
                        items.remove(item);
                        items.add(item);
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(items.toString().replaceAll("[\\[\\]]", ""));
    }
}
