package D_Java_OOP.E_Polymorphism.L04_WildFarm;

public class Tiger extends Feline {

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public boolean isEatingThisFood(Food food) {
        return food instanceof Meat;
    }
}
