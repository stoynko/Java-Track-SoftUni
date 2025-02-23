package D_OOP.A_WorkingWithAbstraction.E06_GreedyTimes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");
        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < safe.length; i += 2) {

            String itemName = safe[i];
            long quantity = Long.parseLong(safe[i + 1]);
            Item item = createItem(itemName, quantity);
            if (item != null) {
                bag.addItem(item);
            }
        }
        System.out.println(bag);
    }

    private static Item createItem(String itemName, long quantity) {

        ItemType itemType;

        if (itemName.length() == 3) {
            itemType = ItemType.CASH;
        } else if (itemName.toLowerCase().endsWith("gem")) {
            itemType = ItemType.GEM;
        } else if (itemName.equalsIgnoreCase("gold")) {
            itemType = ItemType.GOLD;
        } else {
            return null;
        }
        return new Item(itemType, itemName, quantity);
    }
}