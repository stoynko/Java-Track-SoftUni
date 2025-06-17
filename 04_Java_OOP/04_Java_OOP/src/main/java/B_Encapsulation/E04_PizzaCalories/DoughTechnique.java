package B_Encapsulation.E04_PizzaCalories;

public enum DoughTechnique {

    Crispy(0.9),
    Chewy(1.1),
    Homemade(1.0);

    private double modifier;

    DoughTechnique(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
}
