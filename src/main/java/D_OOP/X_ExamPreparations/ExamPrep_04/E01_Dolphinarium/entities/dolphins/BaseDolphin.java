package D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.dolphins;

import D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.common.*;
import D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.foods.*;

public class BaseDolphin implements Dolphin{

    public static final int BASE_JUMP_ENERGY_CONSUMPTION = 10;

    private String name;
    private int energy;

    public BaseDolphin(String name, int energy) {
        setName(name);
        setEnergy(energy);
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.DOLPHIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(int energy) {
        if (energy < 0) {
            energy = 0;
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public void jump() {
        this.energy -= BASE_JUMP_ENERGY_CONSUMPTION;
    }

    @Override
    public void eat(Food food) {
        switch (food.getCalories()) {
            case 175: this.energy += 175;
                break;
            case 200: this.energy += 200;
                break;
            case 305: this.energy += 305;
                break;
        }
    }
}
