package D_Java_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.diving;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.diver.Diver;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.divingSite.DivingSite;

import java.util.Collection;

public interface Diving {
    void searching(DivingSite divingSite, Collection<Diver> divers);
}
