package Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.repositories;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getCollection();

    void add(T destination);

    boolean remove(T destination);

    T byName(String name);
}
