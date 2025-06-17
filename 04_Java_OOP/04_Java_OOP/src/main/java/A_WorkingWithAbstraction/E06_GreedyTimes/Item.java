package A_WorkingWithAbstraction.E06_GreedyTimes;

public class Item {

    private ItemType itemType;
    private String itemName;
    private long quantity;

    public Item(ItemType itemType, String itemName, long quantity) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
