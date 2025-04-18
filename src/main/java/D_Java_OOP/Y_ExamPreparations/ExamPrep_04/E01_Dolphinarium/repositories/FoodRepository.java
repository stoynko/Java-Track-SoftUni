package D_Java_OOP.Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.repositories;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.foods.Food;

public interface FoodRepository {

    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
