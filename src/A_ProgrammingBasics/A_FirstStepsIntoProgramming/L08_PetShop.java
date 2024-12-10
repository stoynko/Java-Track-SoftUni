package A_ProgrammingBasics.A_FirstStepsIntoProgramming;

import java.util.*;

public class L08_PetShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dogFood = Integer.parseInt(scanner.nextLine());
        int catFood = Integer.parseInt(scanner.nextLine());

        double dogFoodPrice = 2.5;
        double catFoodPrice = 4;
        double result = (dogFood * dogFoodPrice) + (catFood * catFoodPrice);

        System.out.printf("%f lv.", result);
    }
}
