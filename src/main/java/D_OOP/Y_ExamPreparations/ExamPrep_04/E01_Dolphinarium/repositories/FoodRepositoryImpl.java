package D_OOP.Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.repositories;

import D_OOP.Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.foods.*;

import java.util.*;

public class FoodRepositoryImpl implements FoodRepository{

    private Collection<Food> foods;

    public FoodRepositoryImpl() {
        this.foods = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        this.foods.add(food);
    }

    @Override
    public boolean remove(Food food) {
        return this.foods.remove(food);
    }

    @Override
    public Food findByType(String type) {
        return this.foods.stream().filter(food -> food.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
