package A_FirstStepsIntoProgramming;

import java.util.*;

public class E06_Repainting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nylonNeeded = Integer.parseInt(scanner.nextLine()) + 2;
        int paintNeededSubTotal = Integer.parseInt(scanner.nextLine());
        int thinnerNeeded = Integer.parseInt(scanner.nextLine());
        int timeNeeded = Integer.parseInt(scanner.nextLine());

        double nylonPrice = 1.5;
        double paintPrice = 14.5;
        double thinnerPrice = 5;
        double bagPrice = 0.4;

        double paintNeeded = paintNeededSubTotal + (paintNeededSubTotal * 0.1);
        double materialCosts = (paintNeeded * paintPrice) + (nylonNeeded * nylonPrice) + (thinnerNeeded * thinnerPrice) + bagPrice;

        double workerCostsPerHour = materialCosts * 0.3;
        double workersCosts = workerCostsPerHour * timeNeeded;

        double total = materialCosts + workersCosts;

        System.out.println(total);
    }
}