package Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getCollection();

    void add(T entity);

    boolean remove(T entity);

    T byName(String name);
}
