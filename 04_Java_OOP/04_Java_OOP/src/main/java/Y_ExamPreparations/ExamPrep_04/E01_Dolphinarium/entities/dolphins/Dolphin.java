package Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.dolphins;

import Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.foods.Food;

public interface Dolphin {
    String getName();
    int getEnergy();

    void jump();

    void eat(Food food);
}
