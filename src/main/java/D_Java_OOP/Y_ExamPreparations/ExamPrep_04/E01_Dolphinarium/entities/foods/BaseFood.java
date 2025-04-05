package D_Java_OOP.Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.entities.foods;

public class BaseFood implements Food {

    private int calories;

    public BaseFood(int calories) {
        this.calories = calories;
    }

    @Override
    public int getCalories() {
        return this.calories;
    }
}
