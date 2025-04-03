package D_OOP.X_ExamPreparations.ExamPrep_10.repositories.interfaces;

public interface BoothRepository<T> extends Repository<T> {
    T getByNumber(int number);
}
