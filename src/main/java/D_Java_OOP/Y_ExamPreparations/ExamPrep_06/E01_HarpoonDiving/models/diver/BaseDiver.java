package D_Java_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.diver;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.common.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.seaCatch.*;

public class BaseDiver implements Diver {

    public static final double BASE_OXYGEN_DECREASE = 30;

    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    public BaseDiver(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.seaCatch = new BaseSeaCatch();
    }

    @Override
    public void shoot() {
        this.oxygen -= BASE_OXYGEN_DECREASE;
        if (this.oxygen < 0) {
            this.oxygen = 0;
        }
    }

    @Override
    public boolean canDive() {
        return this.oxygen > 0;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return this.seaCatch;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }
}
