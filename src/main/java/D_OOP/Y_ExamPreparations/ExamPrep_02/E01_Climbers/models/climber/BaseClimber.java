package D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.models.climber;

import D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.common.ExceptionMessages;
import D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.models.roster.Roster;
import D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.models.roster.RosterImpl;

public class BaseClimber implements Climber {

    public static final double CLIMBER_STRENGTH_REDUCTION = 30;

    private String name;
    private double strength;
    private Roster roster;

    public BaseClimber(String name, double strength) {
        this.name = name;
        this.strength = strength;
        this.roster = new RosterImpl();
    }

    @Override
    public void climb() {
        this.strength -= CLIMBER_STRENGTH_REDUCTION;
        if (this.strength < 0) {
            this.strength = 0;
        }
    }

    @Override
    public boolean canClimb() {
        return this.strength > 0;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.CLIMBER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setStrength(double strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(ExceptionMessages.CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getStrength() {
        return this.strength;
    }

    @Override
    public Roster getRoster() {
        return this.roster;
    }
}
