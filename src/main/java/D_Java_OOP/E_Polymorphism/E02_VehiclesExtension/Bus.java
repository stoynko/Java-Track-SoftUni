package D_Java_OOP.E_Polymorphism.E02_VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public final static double AIR_CONDITIONER_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        if (getFuelQuantity() >= distance * (getFuelConsumption() + AIR_CONDITIONER_CONSUMPTION)) {
            setFuelQuantity(getFuelQuantity() - ((getFuelConsumption() + AIR_CONDITIONER_CONSUMPTION) * distance));
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", getClass().getSimpleName(), df.format(distance));
        } else {
            return String.format("%s needs refueling", getClass().getSimpleName());
        }
    }

    public String driveEmpty(double distance) {
        if (getFuelQuantity() >= distance * getFuelConsumption()) {
            setFuelQuantity(getFuelConsumption() * distance);
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", getClass().getSimpleName(), df.format(distance));
        } else {
            return String.format("%s needs refueling", getClass().getSimpleName());
        }
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", this.getFuelQuantity());
    }
}
