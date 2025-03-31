package D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking.repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getCollection();
    void add(T entity);
    boolean remove(T entity);
    T byName(String name);
}
