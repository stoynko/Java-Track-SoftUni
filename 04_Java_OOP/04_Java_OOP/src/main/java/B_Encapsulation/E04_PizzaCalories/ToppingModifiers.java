package B_Encapsulation.E04_PizzaCalories;

public enum ToppingModifiers {

    Meat(1.2),
    Veggies(0.8),
    Cheese(1.1),
    Sauce(0.9);

    private double modifier;

    ToppingModifiers(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
}
