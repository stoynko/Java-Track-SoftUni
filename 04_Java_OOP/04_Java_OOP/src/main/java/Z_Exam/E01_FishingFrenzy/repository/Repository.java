package Z_Exam.E01_FishingFrenzy.repository;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getCollection();
    void add(T entity);
    boolean remove(T entity);
    T byName(String name);
}
