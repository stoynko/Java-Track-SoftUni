package D_Java_OOP.Y_ExamPreparations.ExamPrep_05.E01_Restaurant.repositories;
import java.util.Collection;

public interface Repository<T> {

    Collection<T> getCollection();

    void add(T entity);

    boolean remove(T entity);

    T byName(String name);
}
