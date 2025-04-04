package D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.models.climber;

public class RockClimber extends BaseClimber {

    public static final double ROCK_CLIMBER_INITIAL_STRENGTH = 120;

    public RockClimber(String name) {
        super(name, ROCK_CLIMBER_INITIAL_STRENGTH);
    }

    @Override
    public void climb() {
        double currentStrength = super.getStrength();
        double updatedStrength = currentStrength - (2 * CLIMBER_STRENGTH_REDUCTION);
        if (updatedStrength < 0) {
            super.setStrength(0);
        } else {
            super.setStrength(updatedStrength);
        }
    }
}
