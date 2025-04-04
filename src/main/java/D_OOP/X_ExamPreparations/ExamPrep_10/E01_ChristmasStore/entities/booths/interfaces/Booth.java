package D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.booths.interfaces;

public interface Booth {
    int getBoothNumber();
    int getCapacity();
    boolean isReserved();
    double getPrice();
    void reserve(int numberOfPeople);
    double getBill();
    void clear();
}
