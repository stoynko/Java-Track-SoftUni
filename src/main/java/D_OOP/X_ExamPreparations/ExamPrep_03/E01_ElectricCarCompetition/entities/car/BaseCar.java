package D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.car;

import D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.common.ExceptionMessages;

public class BaseCar implements Car {

    public static final int INITIAL_MILEAGE = 0;
    public static final int BATTERY_CAPACITY_EXPENDED = 15;
    public static final int MILEAGE_INCREMENT = 25;

    private String model;
    private int batteryCapacity;
    private int mileage;

    public BaseCar(String model, int batteryCapacity) {
        setModel(model);
        setBatteryCapacity(batteryCapacity);
        this.mileage = INITIAL_MILEAGE;
    }

    public void setModel(String model) {
        if (model == null || model.isBlank()) {
            throw new NullPointerException(ExceptionMessages.CAR_MODEL_NULL_OR_EMPTY);
        }
        this.model = model;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getBatteryCapacity() {
        return this.batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public int getMileage() {
        return this.mileage;
    }

    @Override
    public void drive() {
        this.batteryCapacity -= BATTERY_CAPACITY_EXPENDED;
        if (this.batteryCapacity < 0) {
            this.batteryCapacity = 0;
        }
        this.mileage += MILEAGE_INCREMENT;
    }
}
