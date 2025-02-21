package D_OOP.B_Encapsulation.E04_PizzaCalories;

public enum DoughModifiers {

    White(1.5),
    Wholegrain(1),
    Crispy(0.9),
    Chewy(1.1),
    Homemade(1.0);

    private double modifier;

    DoughModifiers(double modifier) {
        this.modifier = modifier;
    }
}
