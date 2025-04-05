package D_Java_OOP.B_Encapsulation.E04_PizzaCalories;

public enum DoughType {

    White(1.5),
    Wholegrain(1);

    private double modifier;

    DoughType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
}
