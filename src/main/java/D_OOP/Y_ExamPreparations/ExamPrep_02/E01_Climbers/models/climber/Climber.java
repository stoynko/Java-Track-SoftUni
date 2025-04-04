package D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.models.climber;

import D_OOP.Y_ExamPreparations.ExamPrep_02.E01_Climbers.models.roster.Roster;

public interface Climber {
    String getName();
    double getStrength();
    boolean canClimb();
    Roster getRoster();
    void climb();
}
