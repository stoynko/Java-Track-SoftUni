package D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.places;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.pickers.Picker;

import java.util.Collection;

public interface Place {

    String getName();
    Collection<String> getMushrooms();
    Collection<Picker> getPickers();
}
