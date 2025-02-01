package C_Advanced.F_DefiningClasses.E03_SpeedRacing;

public class Car {

    public static final int DEFAULT_DISTANCE_TRAVELED = 0;

    private String model;
    private double fuelAmount;
    private int distanceTraveled;
    private double fuelCostPerKm;

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.distanceTraveled = DEFAULT_DISTANCE_TRAVELED;
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    public boolean carCanMove(String model, int amountOfKm) {
        return amountOfKm * fuelCostPerKm <= fuelAmount;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(getModel() + " " + String.format("%.2f", getFuelAmount()) + " " + getDistanceTraveled())
              .append(System.lineSeparator());

        return output.toString();
    }
}
