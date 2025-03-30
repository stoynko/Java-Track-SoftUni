package D_OOP.X_ExamPreparations.ExamPrep_07.E01_Handball.repositories;

import D_OOP.X_ExamPreparations.ExamPrep_07.E01_Handball.entities.equipment.Equipment;

public interface Repository {
    void add(Equipment equipment);
    boolean remove(Equipment equipment);
    Equipment findByType(String type);
}
