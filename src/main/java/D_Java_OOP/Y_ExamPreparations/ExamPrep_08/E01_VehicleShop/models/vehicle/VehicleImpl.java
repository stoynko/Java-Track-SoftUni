package D_Java_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.vehicle;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.common.*;

public class VehicleImpl implements Vehicle {

    public static final int VEHICLE_STRENGTH_REQUIRED_LOSS = 5;

    private String name;
    private int strengthRequired;

    public VehicleImpl(String name, int strengthRequired) {
        setName(name);
        setStrengthRequired(strengthRequired);
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setStrengthRequired(int strengthRequired) {
        if (strengthRequired < 0) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }
        this.strengthRequired = strengthRequired;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthRequired() {
        return this.strengthRequired;
    }

    @Override
    public boolean reached() {
        return strengthRequired == 0;
    }

    @Override
    public void making() {
        this.strengthRequired -= VEHICLE_STRENGTH_REQUIRED_LOSS;
        if (this.strengthRequired < 0) {
            this.strengthRequired = 0;
        }
    }
}
