package D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.cocktails;

public class MulledWine extends BaseCocktail {

    public static final double MULLED_WINE_DEFAULT_PRICE = 3.5;

    public MulledWine(String name, int size, String brand) {
        super(name, size, MULLED_WINE_DEFAULT_PRICE, brand);
    }
}
