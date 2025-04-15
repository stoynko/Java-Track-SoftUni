package A_Java_ProgrammingBasics.B_ConditionalStatements;

import java.util.*;

public class E07_Shopping {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int videoCardsOrdered = Integer.parseInt(scanner.nextLine());
        int processorsOrdered = Integer.parseInt(scanner.nextLine());
        int ramSticksOrdered = Integer.parseInt(scanner.nextLine());
        double total = 0;
        double videoCardPrice = 250;
        double processorPrice = (videoCardsOrdered * videoCardPrice) * 0.35;
        double ramStickPrice = (videoCardsOrdered * videoCardPrice) * 0.1;
        boolean VP = videoCardsOrdered > processorsOrdered;

        if (VP) {
            total = ((videoCardsOrdered * videoCardPrice) + (processorsOrdered * processorPrice) +
                    (ramSticksOrdered * ramStickPrice)) * 0.85;
        } else {
            total = (videoCardsOrdered * videoCardPrice) + (processorsOrdered * processorPrice) +
                    (ramSticksOrdered * ramStickPrice);
        }

        boolean enough = budget >= total;

        if (enough) {
            System.out.printf("You have %.2f leva left!", budget - total);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", total - budget);
        }
    }
}
