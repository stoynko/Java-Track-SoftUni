package D_OOP.X_ExamPreparations.ExamPrep_10.entities.cocktails;

public class MulledWine extends BaseCocktail {

    public static final double MULLED_WINE_DEFAULT_PRICE = 3.5;

    public MulledWine(String name, int size, String brand) {
        super(name, size, MULLED_WINE_DEFAULT_PRICE, brand);
    }
}
