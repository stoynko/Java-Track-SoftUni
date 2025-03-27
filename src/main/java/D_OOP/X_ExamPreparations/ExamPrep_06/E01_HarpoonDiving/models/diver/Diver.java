package D_OOP.X_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.diver;

import D_OOP.X_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.seaCatch.SeaCatch;

public interface Diver {
    String getName();
    double getOxygen();
    boolean canDive();
    SeaCatch getSeaCatch();
    void shoot();
}
