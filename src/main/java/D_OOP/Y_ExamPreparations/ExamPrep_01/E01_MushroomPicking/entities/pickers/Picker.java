package D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.pickers;

import D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.bag.Bag;

public interface Picker {
    String getName();
    int getVitality();
    Bag getBag();
    void pick();
}
