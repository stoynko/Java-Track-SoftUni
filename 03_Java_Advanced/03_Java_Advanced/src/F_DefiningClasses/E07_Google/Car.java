package F_DefiningClasses.E07_Google;

public class Car {

    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return model + " " + speed;
    }
}
