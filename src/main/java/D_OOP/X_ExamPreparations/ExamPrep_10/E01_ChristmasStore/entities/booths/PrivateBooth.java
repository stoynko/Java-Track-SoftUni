package D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.booths;

public class PrivateBooth extends BaseBooth {

    public static final double PRIVATE_BOOTH_PRICE_PER_PERSON = 3.5;

    public PrivateBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRIVATE_BOOTH_PRICE_PER_PERSON);
    }
}
