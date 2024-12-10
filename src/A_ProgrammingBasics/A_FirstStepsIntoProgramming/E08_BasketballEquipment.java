package A_ProgrammingBasics.A_FirstStepsIntoProgramming;

import java.util.*;

public class E08_BasketballEquipment {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int yearlyCost = Integer.parseInt(scanner.nextLine());

        double shoesCost = yearlyCost - (yearlyCost * 0.4);
        double jerseyCost = shoesCost - (shoesCost * 0.2);
        double ballCost = jerseyCost * 0.25;
        double accessoriesCost = ballCost * 0.2;

        double totalCosts = shoesCost + jerseyCost + ballCost + accessoriesCost;
        System.out.println(totalCosts + yearlyCost);
    }
}
