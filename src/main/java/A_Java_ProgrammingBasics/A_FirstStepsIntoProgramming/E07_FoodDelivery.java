package A_Java_ProgrammingBasics.A_FirstStepsIntoProgramming;

import java.util.*;

public class E07_FoodDelivery {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int chickenMealsOrdered = Integer.parseInt(scanner.nextLine());
        int fishMealsOrdered = Integer.parseInt(scanner.nextLine());
        int vegMealsOrdered = Integer.parseInt(scanner.nextLine());
        double deliveryCosts = 2.5;
        double chickenMealPrice = 10.35;
        double fishMealPrice = 12.40;
        double vegMealPrice = 8.15;

        double subTotal = (chickenMealPrice * chickenMealsOrdered) + (fishMealPrice * fishMealsOrdered) +
                                                                        (vegMealPrice * vegMealsOrdered);
        double dessertPrice = subTotal * 0.2;
        double total = subTotal + deliveryCosts + dessertPrice;

        System.out.println(total);
    }
}
