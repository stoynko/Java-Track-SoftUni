package D_Java_OOP.E_Polymorphism.E01_Vehicles;

public class Car extends Vehicle {

    public final static double AIR_CONDITIONER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_CONSUMPTION);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", this.getFuelQuantity());
    }
}


