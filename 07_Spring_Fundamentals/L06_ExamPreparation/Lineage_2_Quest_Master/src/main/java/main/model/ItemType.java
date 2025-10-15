package main.model;

public enum ItemType {

    WEAPON("Weapon"),
    ARMOR("Armor"),
    OTHER("Other");

    private final String itemType;

    ItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemType() {
        return itemType;
    }
}
