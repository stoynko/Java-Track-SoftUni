package D_Java_OOP.B_Encapsulation.E04_PizzaCalories;

public class Topping {

    private static final double BASE_CALORIES = 2;

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        try {
            ToppingModifiers.valueOf(toppingType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double calorie = ToppingModifiers.valueOf(toppingType).getModifier();
        return BASE_CALORIES * weight * calorie;
    }
}
