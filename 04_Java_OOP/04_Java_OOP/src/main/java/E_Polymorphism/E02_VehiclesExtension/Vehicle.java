package E_Polymorphism.E02_VehiclesExtension;

import java.text.*;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public String drive(double distance){
        if (fuelQuantity >= distance * fuelConsumption) {
            fuelQuantity -= distance * fuelConsumption;
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", getClass().getSimpleName(), df.format(distance));
        } else {
            return String.format("%s needs refueling", getClass().getSimpleName());
        }
    }

    public void refuel (double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (liters + getFuelQuantity() > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += liters;
        }
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }
}
