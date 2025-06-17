package Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.delicacies;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.common.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.delicacies.interfaces.*;

public class BaseDelicacy implements Delicacy {

    private String name;
    private double portion;
    private double price;

    public BaseDelicacy(String name, double portion, double price) {
        setName(name);
        setPortion(portion);
        setPrice(price);
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.name = name;
    }

    public void setPortion(double portion) {
        if (portion <= 0 ) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
        }
        this.portion = portion;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2f", this.name, this.portion, this.price);
    }
}
