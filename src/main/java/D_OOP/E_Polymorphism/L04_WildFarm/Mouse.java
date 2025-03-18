package D_OOP.E_Polymorphism.L04_WildFarm;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight,livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public boolean isEatingThisFood(Food food) {
       return food instanceof Vegetable;
    }

    @Override
    public void eat(Food food) {
        if (isEatingThisFood(food)) {
            super.eat(food);
        } else {
            throw new IllegalArgumentException(String.format("Mice are not eating that type of food!"));
        }
    }
}
