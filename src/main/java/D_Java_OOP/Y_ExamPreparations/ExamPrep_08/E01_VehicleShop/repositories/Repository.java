package D_Java_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getWorkers();
    void add(T model);
    boolean remove(T model);
    T findByName(String name);
}
