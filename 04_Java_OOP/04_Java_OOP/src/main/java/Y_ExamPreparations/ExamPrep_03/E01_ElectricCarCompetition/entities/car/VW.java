package Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.car;

public class VW extends BaseCar {

    public static final int INITIAL_BATTERY_CAPACITY = 50;

    public VW(String model) {
        super(model, INITIAL_BATTERY_CAPACITY);
    }
}
