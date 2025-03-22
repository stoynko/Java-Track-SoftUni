package D_OOP.X_ExamPreparations.ExamPrep_05.E02_UnitTesting;

public class FullTimeWaiter {

    private final String name;
    private final int efficiency;


    public FullTimeWaiter(String name, int efficiency) {
        this.name = name;
        this.efficiency = efficiency;
    }

    public String getName() {
        return name;
    }

    public int getEfficiency() {
        return efficiency;
    }
}
