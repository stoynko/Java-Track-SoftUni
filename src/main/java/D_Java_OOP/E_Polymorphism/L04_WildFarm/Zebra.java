package D_Java_OOP.E_Polymorphism.L04_WildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public boolean isEatingThisFood(Food food) {
        return food instanceof Vegetable;
    }
}
