package Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.repositories.interfaces;

import java.util.*;

public interface Repository<T> {
    Collection<T> getAll();
    void add(T t);
}
