package Y_ExamPreparations.ExamPrep_07.E01_Handball.repositories;

import Y_ExamPreparations.ExamPrep_07.E01_Handball.entities.equipment.Equipment;

public interface Repository {
    void add(Equipment equipment);
    boolean remove(Equipment equipment);
    Equipment findByType(String type);
}
