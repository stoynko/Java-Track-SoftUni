package Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.pools;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.common.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.dolphins.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.foods.*;

import java.util.*;

public class BasePool implements Pool {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Dolphin> dolphins;

    public BasePool(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.dolphins = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
        throw new NullPointerException(ExceptionMessages.POOL_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void addDolphin(Dolphin dolphin) {
        if (this.dolphins.size() + 1 > this.capacity) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        if (dolphin.getEnergy() <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.DOLPHIN_ENERGY_BELOW_OR_EQUAL_ZERO);
        }
        this.dolphins.add(dolphin);
    }

    @Override
    public void removeDolphin(Dolphin dolphin) {
        this.dolphins.remove(dolphin);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public Collection<Dolphin> getDolphins() {
        return this.dolphins;
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }
}
