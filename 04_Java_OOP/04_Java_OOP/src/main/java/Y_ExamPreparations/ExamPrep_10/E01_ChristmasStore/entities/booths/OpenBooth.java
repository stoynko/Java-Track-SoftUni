package Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.booths;

public class OpenBooth extends BaseBooth {

    public static final double OPEN_BOOTH_PRICE_PER_PERSON = 2.5;

    public OpenBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, OPEN_BOOTH_PRICE_PER_PERSON);
    }
}
