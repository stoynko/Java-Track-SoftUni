package Y_ExamPreparations.ExamPrep_03.E02_Garage;

public class Car {

    private final String brand;

    private final int power;

    private final String color;


    public Car(String brand, int power, String color) {
        this.brand = brand;
        this.power = power;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getPower() {
        return power;
    }

    public String getColor() {
        return color;
    }
}
