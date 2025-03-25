package D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.pools;

import D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.dolphins.Dolphin;
import D_OOP.X_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.foods.Food;

import java.util.Collection;

public interface Pool {
    String getName();

    int getCapacity();

    Collection<Dolphin> getDolphins();

    Collection<Food> getFoods();

    void addDolphin(Dolphin dolphin);

    void removeDolphin(Dolphin dolphin);

    void addFood(Food food);
}
