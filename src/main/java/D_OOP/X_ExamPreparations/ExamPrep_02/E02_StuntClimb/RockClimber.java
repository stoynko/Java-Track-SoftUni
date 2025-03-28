package D_OOP.X_ExamPreparations.ExamPrep_02.E02_StuntClimb;

public class RockClimber {
    private final String name;
    private final double strength;

    public RockClimber(String name, double strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return this.name;
    }

    public double getStrength() {
        return this.strength;
    }
}
