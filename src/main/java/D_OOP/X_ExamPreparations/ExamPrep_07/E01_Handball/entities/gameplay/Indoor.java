package D_OOP.X_ExamPreparations.ExamPrep_07.E01_Handball.entities.gameplay;

import D_OOP.X_ExamPreparations.ExamPrep_07.E01_Handball.entities.team.*;

public class Indoor extends BaseGameplay {

    private static final int INDOOR_CAPACITY = 250;

    public Indoor(String name) {
        super(name, INDOOR_CAPACITY);
    }
}
