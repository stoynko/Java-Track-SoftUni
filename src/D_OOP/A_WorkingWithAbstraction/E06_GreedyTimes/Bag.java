package D_OOP.A_WorkingWithAbstraction.E06_GreedyTimes;

import java.util.*;
import java.util.stream.*;

public class Bag {

    private long capacity;
    private List<Item> itemsList;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.itemsList = new ArrayList<>();
    }

    public void addItem(Item item) {

        if (itemMeetsCriteria(item)) {

            Item existingItem = this.itemsList.stream()
                    .filter(e -> e.getItemType().equals(item.getItemType()) && e.getItemName().equals(item.getItemName()))
                    .findFirst()
                    .orElse(null);

            if (existingItem != null) {

                switch (item.getItemType()) {
                    case GOLD:
                        long currentQuantity = existingItem.getQuantity();
                        existingItem.setQuantity(currentQuantity + item.getQuantity());
                        break;
                    case GEM:
                        if (existingItem.getItemName().equals(item.getItemName())) {
                            currentQuantity = existingItem.getQuantity();
                            existingItem.setQuantity(currentQuantity + item.getQuantity());
                        } else {
                            this.itemsList.add(item);
                        }
                        break;
                    case CASH:
                        if (existingItem.getItemName().equals(item.getItemName())) {
                            currentQuantity = existingItem.getQuantity();
                            existingItem.setQuantity(currentQuantity + item.getQuantity());
                        } else {
                            this.itemsList.add(item);
                        }
                        break;
                }
            } else {
                this.itemsList.add(item);
            }
        }
    }

    private boolean itemMeetsCriteria(Item item) {
        if (capacity < getTotalAmount() + item.getQuantity()) {
            return false;
        }

        switch (item.getItemType()) {
            case GEM:
                if (getAmount(ItemType.GEM) + item.getQuantity() > getAmount(ItemType.GOLD)) {
                    return false;
                }
            break;
            case CASH:
                if (getAmount(ItemType.CASH) + item.getQuantity() > getAmount(ItemType.GEM)) {
                    return false;
                }
            break;
        }
        return true;
    }

    public long getTotalAmount() {
        return getAmount(ItemType.GEM) + getAmount(ItemType.GOLD) + getAmount(ItemType.CASH);
    }

    public long getAmount(ItemType itemType) {
        return this.itemsList.stream().filter(item -> item.getItemType().equals(itemType)).mapToLong(Item::getQuantity).sum();
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();

        List<Item> gems = this.itemsList.stream().filter(item -> item.getItemType().equals(ItemType.GEM))
                                                        .sorted(Comparator.comparing(Item::getItemName).reversed()
                                                        .thenComparing(Item::getQuantity, Comparator.reverseOrder()))
                                                        .collect(Collectors.toList());
        List<Item> cash = this.itemsList.stream().filter(item -> item.getItemType().equals(ItemType.CASH))
                                                        .sorted(Comparator.comparing(Item::getItemName).reversed()
                                                        .thenComparing(Item::getQuantity, Comparator.reverseOrder()))
                                                        .collect(Collectors.toList());

        long goldAmount = getAmount(ItemType.GOLD);
        if (goldAmount > 0) {
            output.append(String.format("<Gold> $%d\n", goldAmount));
            output.append(String.format("##Gold - %d\n", goldAmount));
        }
        
        if (!gems.isEmpty()) {
            output.append(String.format("<Gem> $%d\n", getAmount(ItemType.GEM)));
            for (Item gem : gems) {
                output.append(String.format("##%s - %d\n", gem.getItemName(), gem.getQuantity()));
            }
        }

        if (!cash.isEmpty()) {
            output.append(String.format("<Cash> $%d\n", getAmount(ItemType.CASH)));
            for (Item currency : cash) {
                output.append(String.format("##%s - %d\n", currency.getItemName(), currency.getQuantity()));
            }
        }
        return output.toString();
    }
}

