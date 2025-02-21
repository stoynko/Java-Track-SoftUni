package D_OOP.B_Encapsulation.E04_PizzaCalories;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] pizzaInfo = scanner.nextLine().split(" ");
        String pizzaName = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);

        String[] doughInfo = scanner.nextLine().split(" ");
        String flourType = doughInfo[1];
        String bakingTechniques = doughInfo[2];
        double doughWeight = Double.parseDouble(doughInfo[3]);

        Pizza pizza = null;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Dough dough = null;
        try {
            dough = new Dough(flourType, bakingTechniques, doughWeight);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] toppingInfo = input.split(" ");
            String toppingType = toppingInfo[1];
            double toppingWeight = Double.parseDouble(toppingInfo[2]);
            Topping topping = new Topping(toppingType, toppingWeight);
            pizza.addTopping(topping);
            input = scanner.nextLine();
        }

        if (pizza != null) {
            System.out.printf("%s - \n", pizzaName);
        }
    }
}