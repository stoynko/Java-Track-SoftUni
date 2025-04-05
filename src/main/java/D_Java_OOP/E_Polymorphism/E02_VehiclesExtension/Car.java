package D_Java_OOP.E_Polymorphism.E02_VehiclesExtension;

public class Car extends Vehicle {

    public final static double AIR_CONDITIONER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_CONSUMPTION, tankCapacity);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", this.getFuelQuantity());
    }
}


