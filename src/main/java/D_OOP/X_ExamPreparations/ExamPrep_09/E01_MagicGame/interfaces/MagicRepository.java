package D_OOP.X_ExamPreparations.ExamPrep_09.E01_MagicGame.interfaces;

import D_OOP.X_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magics.Magic;

import java.util.Collection;

public interface MagicRepository<T> {
    Collection<T> getData();
    void addMagic(Magic model);
    boolean removeMagic(Magic model);
    T findByName(String name);
}
