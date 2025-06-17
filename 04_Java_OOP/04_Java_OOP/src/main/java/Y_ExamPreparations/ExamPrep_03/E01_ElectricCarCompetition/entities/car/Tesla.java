package Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.car;

public class Tesla extends BaseCar {

    public static final int INITIAL_BATTERY_CAPACITY = 85;

    public Tesla(String model) {
        super(model, INITIAL_BATTERY_CAPACITY);
    }
}
