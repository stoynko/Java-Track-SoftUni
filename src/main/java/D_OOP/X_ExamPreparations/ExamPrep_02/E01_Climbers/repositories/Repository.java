package D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getCollection();
    void add(T entity);
    boolean remove(T entity);
    T byName(String name);
}
