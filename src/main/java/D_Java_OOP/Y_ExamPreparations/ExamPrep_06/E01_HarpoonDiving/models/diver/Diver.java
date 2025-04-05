package D_Java_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.diver;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.seaCatch.SeaCatch;

public interface Diver {
    String getName();
    double getOxygen();
    boolean canDive();
    SeaCatch getSeaCatch();
    void shoot();
}
