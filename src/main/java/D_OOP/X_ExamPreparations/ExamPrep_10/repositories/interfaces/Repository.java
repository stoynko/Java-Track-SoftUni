package D_OOP.X_ExamPreparations.ExamPrep_10.repositories.interfaces;

import java.util.*;

public interface Repository<T> {
    Collection<T> getAll();
    void add(T t);
}
