package D_OOP.X_ExamPreparations.ExamPrep_09.E01_MagicGame.interfaces;

import D_OOP.X_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magicians.Magician;

import java.util.Collection;

public interface MagicianRepository<T> {
    Collection<T> getData();
    void addMagician(Magician model);
    boolean removeMagician(Magician model);
    T findByUsername(String name);
}
