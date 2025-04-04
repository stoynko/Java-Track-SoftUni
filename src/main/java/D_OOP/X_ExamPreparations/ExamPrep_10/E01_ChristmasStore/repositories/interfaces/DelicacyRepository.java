package D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.repositories.interfaces;

public interface DelicacyRepository<T> extends Repository<T> {
    T getByName(String name);
}
