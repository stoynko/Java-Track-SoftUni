package Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.cocktails;

public class Hibernation extends BaseCocktail {

    public static final double HIBERNATION_DEFAULT_PRICE = 4.5;

    public Hibernation(String name, int size, String brand) {
        super(name, size, HIBERNATION_DEFAULT_PRICE, brand);
    }
}
