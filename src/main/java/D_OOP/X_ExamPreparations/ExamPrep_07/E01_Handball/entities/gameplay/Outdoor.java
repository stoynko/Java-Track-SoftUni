package D_OOP.X_ExamPreparations.ExamPrep_07.E01_Handball.entities.gameplay;

import D_OOP.X_ExamPreparations.ExamPrep_07.E01_Handball.entities.team.*;

import java.util.*;
import java.util.stream.*;

public class Outdoor extends BaseGameplay {

    private static final int OUTDOOR_CAPACITY = 150;

    public Outdoor(String name) {
        super(name, OUTDOOR_CAPACITY);
    }
}
