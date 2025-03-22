package D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructureAndBusinessLogic.repositories;
import java.util.Collection;

public interface Repository<T> {

    Collection<T> getCollection();

    void add(T entity);

    boolean remove(T entity);

    T byName(String name);
}
