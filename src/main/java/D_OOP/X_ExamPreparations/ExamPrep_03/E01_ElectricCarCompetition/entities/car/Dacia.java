package D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.car;

public class Dacia extends BaseCar {

    public static final int INITIAL_BATTERY_CAPACITY = 30;

    public Dacia(String model) {
        super(model, INITIAL_BATTERY_CAPACITY);
    }
}
