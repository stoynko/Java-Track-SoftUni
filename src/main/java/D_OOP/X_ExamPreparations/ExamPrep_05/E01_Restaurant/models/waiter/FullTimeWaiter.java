package D_OOP.X_ExamPreparations.ExamPrep_05.E01_Restaurant.models.waiter;

/* Has 8 initial units of efficiency.
The constructor should take the following values upon initialization:
    •	String name */

public class FullTimeWaiter extends BaseWaiter{

    public static final int FULL_TIME_WAITER_INITIAL_EFFICIENCY = 8;

    public FullTimeWaiter(String name) {
        super(name, FULL_TIME_WAITER_INITIAL_EFFICIENCY);
    }

    @Override
    public void work() {
        int efficiency = getEfficiency() - 1;
        if (efficiency < 0) {
            efficiency = 0;
        }
        setEfficiency(efficiency);
    }
}
