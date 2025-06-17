package X_MidExam.ExamPrep_V04;

import java.util.*;
import java.util.stream.*;

public class P02_ShoppingList {

/*It’s the end of the week and it is time for you to go shopping, so you need to create a shopping list first.

Input:
You will receive an initial list with groceries separated by "!". After that you will be receiving 4 types of commands, until you receive "Go Shopping!"
    •	Urgent {item} - add the item at the start of the list.  If the item already exists, skip this command.
    •	Unnecessary {item} - remove the item with the given name, only if it exists in the list. Otherwise, skip this command.
    •	Correct {oldItem} {newItem} – if the item with the given old name exists, change its name with the new one. If it doesn't exist, skip this command.
    •	Rearrange {item} - if the grocery exists in the list, remove it from its current position and add it at the end of the list.

Constraints:
    •	There won`t be any duplicate items in the initial list

Output:
Print the list with all the groceries, joined by ", ".
    •	"{firstGrocery}, {secondGrocery}, …{nthGrocery}"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {

            String[] actions = input.split(" ");
            String action = actions[0];
            String item = actions[1];

            switch (action) {
                case "Urgent" -> {
                    if (!checkIfItemExists(shoppingList, item)) {
                        shoppingList.add(0, item);
                    }
                }
                case "Unnecessary" -> {
                    if (checkIfItemExists(shoppingList, item)) {
                        shoppingList.remove(item);
                    }
                }
                case "Correct" -> {
                    String newItem = actions[2];
                    if (checkIfItemExists(shoppingList, item)) {
                        int index = shoppingList.indexOf(item);
                        shoppingList.set(index, newItem);
                    }
                }
                case "Rearrange" -> {
                    if (checkIfItemExists(shoppingList, item)) {
                        shoppingList.remove(item);
                        shoppingList.add(item);
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", shoppingList));
    }

    private static boolean checkIfItemExists(List<String> shoppingList, String item) {
        return shoppingList.contains(item);
    }
}
