package D_Java_OOP.E_Polymorphism.L04_WildFarm;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Animal> animalsList = new ArrayList<>();

        while (!input.equals("End")) {

            String[] animalData = input.split("\\s+");
            String animalType = animalData[0];
            String animalName = animalData[1];
            Double animalWeight = Double.parseDouble(animalData[2]);
            String livingRegion = animalData[3];
            String breed = null;
            if (animalType.equals("Cat")) {
                breed = animalData[4];
            }

            Food food = parseFoodInput(scanner);
            Animal animal = null;

            switch (animalType) {
                case "Mouse": animal = new Mouse(animalName, animalType, animalWeight, livingRegion);
                    animalsList.add(animal);
                    break;
                case "Zebra": animal = new Zebra(animalName, animalType, animalWeight, livingRegion);
                    animalsList.add(animal);
                    break;
                case "Cat": animal = new Cat(animalName, animalType, animalWeight, livingRegion, breed);
                    animalsList.add(animal);
                    break;
                case "Tiger": animal = new Tiger(animalName, animalType, animalWeight, livingRegion);
                    animalsList.add(animal);
                    break;
            }
            animal.makeSound();
            try {
                animal.eat(food);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }

        for (Animal animal : animalsList) {
            System.out.println(animal);
        }

    }

    private static Food parseFoodInput(Scanner scanner) {

        String foodDataInput = scanner.nextLine();
        String[] foodData = foodDataInput.split("\\s+");
        String foodType = foodData[0];
        Integer quantity = Integer.parseInt(foodData[1]);

        Food food = null;
        switch (foodType) {
            case "Vegetable": 
                food = new Vegetable(quantity);
                break;
            case "Meat": 
                food = new Meat(quantity);
                break;
        }
        return food;
    }
}
