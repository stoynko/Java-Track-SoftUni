package D_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.models.waiter;

/* Has 4 initial units of efficiency.
The constructor should take the following values upon initialization:
    •	String name */

public class HalfTimeWaiter extends BaseWaiter {

    public static final int HALF_TIME_WAITER_INITIAL_EFFICIENCY = 4;

    public HalfTimeWaiter(String name) {
        super(name, HALF_TIME_WAITER_INITIAL_EFFICIENCY);
    }

    @Override
    public void work() {
        int efficiency = getEfficiency() - 2;
        if (efficiency < 0) {
            efficiency = 0;
        }
        setEfficiency(efficiency);
    }
}
