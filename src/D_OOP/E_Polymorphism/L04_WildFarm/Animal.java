package D_OOP.E_Polymorphism.L04_WildFarm;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public abstract void makeSound();
    public abstract boolean isEatingThisFood (Food food);

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public void eat(Food food) {
        if (isEatingThisFood(food)) {
            foodEaten += food.getQuantity();
        } else {
            throw new IllegalArgumentException(String.format("%ss are not eating that type of food!", getClass().getSimpleName()));
        }
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }
}
