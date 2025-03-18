package D_OOP.B_Encapsulation.E04_PizzaCalories;

public class Dough {

    private static final double BASE_CALORIES = 2;

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        try {
            this.flourType = String.valueOf(DoughType.valueOf(flourType));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        try {
            this.bakingTechnique = String.valueOf(DoughTechnique.valueOf(bakingTechnique));
            this.flourType = String.valueOf(DoughType.valueOf(flourType));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double calorieFlour = DoughType.valueOf(flourType).getModifier();
        double calorieTechnique = DoughTechnique.valueOf(bakingTechnique).getModifier();
        return BASE_CALORIES * weight * calorieFlour * calorieTechnique;
    }
}
