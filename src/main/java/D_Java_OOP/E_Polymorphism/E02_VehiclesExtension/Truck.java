package D_Java_OOP.E_Polymorphism.E02_VehiclesExtension;

public class Truck extends Vehicle {

    public final static double AIR_CONDITIONER_CONSUMPTION = 1.6;
    public final static double REFUELING_COEFFICIENT_AFTER_LEAKAGE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * REFUELING_COEFFICIENT_AFTER_LEAKAGE);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", this.getFuelQuantity());
    }
}
