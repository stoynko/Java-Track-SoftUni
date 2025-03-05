package D_OOP.E_Polymorphism.L04_WildFarm;

public class Cat extends Feline {

    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {

    }

    @Override
    public void eat(Food food) {

    }
}
