package D_Java_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.entities.equipment;

public class BaseEquipment implements Equipment {

    private int protection;
    private double price;

    public BaseEquipment(int protection, double price) {
        this.protection = protection;
        this.price = price;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
