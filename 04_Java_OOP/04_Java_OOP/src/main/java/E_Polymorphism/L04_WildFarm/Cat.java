package E_Polymorphism.L04_WildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline {

    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public boolean isEatingThisFood(Food food) {
        return food instanceof Vegetable || food instanceof Meat;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %s, %d]", getClass().getSimpleName(), super.getAnimalName(), this.breed, df.format(super.getAnimalWeight()), super.getLivingRegion(), super.getFoodEaten());
    }
}
