package D_OOP.E_Polymorphism.L04_WildFarm;

public abstract class Mammal extends Animal {

    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten);
        this.livingRegion = livingRegion;
    }
}
