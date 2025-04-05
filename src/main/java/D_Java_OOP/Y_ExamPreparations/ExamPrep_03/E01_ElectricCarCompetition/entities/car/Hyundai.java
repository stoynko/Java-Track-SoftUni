package D_Java_OOP.Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.car;

public class Hyundai extends BaseCar {

    public static final int INITIAL_BATTERY_CAPACITY = 60;

    public Hyundai(String model) {
        super(model, INITIAL_BATTERY_CAPACITY);
    }
}
