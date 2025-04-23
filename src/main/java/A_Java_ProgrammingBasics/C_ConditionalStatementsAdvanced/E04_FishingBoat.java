package A_Java_ProgrammingBasics.C_ConditionalStatementsAdvanced;

import java.util.*;

public class E04_FishingBoat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fisherMen = Integer.parseInt(scanner.nextLine());
        double total = 0;
        double subTotal = 0;
        double discountInPercentage = 0;
        double discountExtra = 0;
        double shipCost = 0;
        boolean enough;

        if (fisherMen <= 6) {
            if (fisherMen % 2 == 0 && !season.equals("Autumn")) {
                discountExtra = discountExtra + 5;
            }
            discountInPercentage = discountInPercentage + 10;
        } else if (fisherMen > 12) {
            if (fisherMen % 2 == 0 && !season.equals("Autumn")) {
                discountExtra = discountExtra + 5;
            }
            discountInPercentage = discountInPercentage + 25;
        } else {
            if (fisherMen % 2 == 0 && !season.equals("Autumn")) {
                discountExtra = discountExtra + 5;
            }
            discountInPercentage = discountInPercentage + 15;
        }
        switch (season) {
            case "Spring":
                shipCost = 3000;
                break;
            case "Summer":
            case "Autumn":
                shipCost = 4200;
                break;
            case "Winter":
                shipCost = 2600;
                break;
        }

        subTotal = shipCost - (shipCost * (discountInPercentage / 100));
        total = subTotal - (subTotal * (discountExtra / 100));
        enough = budget >= total;
        if (enough) {
            System.out.printf("Yes! You have %.2f leva left.", budget - total);
        } else
            System.out.printf("Not enough money! You need %.2f leva.", total - budget);
    }
}
