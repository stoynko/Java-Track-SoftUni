package D_Java_OOP.E_Polymorphism.E01_Vehicles;

import java.text.*;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
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
        this.fuelQuantity += liters;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }
}
