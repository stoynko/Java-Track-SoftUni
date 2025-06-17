package B_ConditionalStatements;

import java.util.*;

public class E05_GodzillaVsKong {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double movieBudget = Double.parseDouble(scanner.nextLine());
        int actors = Integer.parseInt(scanner.nextLine());
        double clothingCostsPerActor = Double.parseDouble(scanner.nextLine());
        double clothingCostsTotal = 0;
        double decorCosts = movieBudget * 0.1;

        if (actors > 150) {
            clothingCostsTotal = (actors * clothingCostsPerActor) - ((actors * clothingCostsPerActor) * 0.1);
        } else {
            clothingCostsTotal = actors * clothingCostsPerActor;
        }

        if (clothingCostsTotal + decorCosts > movieBudget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", (clothingCostsTotal + decorCosts) - movieBudget);
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", movieBudget - (clothingCostsTotal + decorCosts));
        }
    }
}
