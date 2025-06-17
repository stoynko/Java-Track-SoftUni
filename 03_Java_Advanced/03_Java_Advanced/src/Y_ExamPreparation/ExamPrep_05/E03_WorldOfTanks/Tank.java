package Y_ExamPreparation.ExamPrep_05.E03_WorldOfTanks;

public class Tank {

    private String brand;
    private String model;
    private int weight;
    private int barrelCaliber;
    private int armor;

    public Tank(String brand, String model, int weight, int barrelCaliber, int armor) {
        this.brand = brand;
        this.model = model;
        this.weight = weight;
        this.barrelCaliber = barrelCaliber;
        this.armor = armor;
    }

    @Override
    public String toString() {

        return String.format("Brand: %s, Model: %s, Weight: %dkg, Barrel caliber: %dmm, Armor: %dmm", this.brand, this.model, this.weight, this.barrelCaliber, this.armor);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    public int getBarrelCaliber() {
        return barrelCaliber;
    }

    public int getArmor() {
        return armor;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setBarrelCaliber(int barrelCaliber) {
        this.barrelCaliber = barrelCaliber;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
