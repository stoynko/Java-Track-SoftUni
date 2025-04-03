package D_OOP.X_ExamPreparations.ExamPrep_10.repositories.interfaces;

public interface DelicacyRepository<T> extends Repository<T> {
    T getByName(String name);
}
