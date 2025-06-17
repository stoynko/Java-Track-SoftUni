package Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.repositories.interfaces;

public interface BoothRepository<T> extends Repository<T> {
    T getByNumber(int number);
}
