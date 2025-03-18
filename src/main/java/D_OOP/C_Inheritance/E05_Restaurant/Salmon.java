package D_OOP.C_Inheritance.E05_Restaurant;

import java.math.*;

public class Salmon extends MainDish {

    private static final double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}
