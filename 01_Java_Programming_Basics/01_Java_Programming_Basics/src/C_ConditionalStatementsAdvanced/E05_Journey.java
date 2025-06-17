package C_ConditionalStatementsAdvanced;

import java.util.*;

public class E05_Journey {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String destination;
        String accomodationType;
        double accomodationPrice;

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        if (budget <= 100) {
            destination = "Bulgaria";
            if (season.equals("summer")) {
                accomodationPrice = budget * 0.3;
                accomodationType = "Camp";
                System.out.printf("Somewhere in %s\n", destination);
                System.out.printf("%s - %.2f", accomodationType, accomodationPrice);
            }
            if (season.equals("winter")) {
                accomodationPrice = budget * 0.7;
                accomodationType = "Hotel";
                System.out.printf("Somewhere in %s\n", destination);
                System.out.printf("%s - %.2f", accomodationType, accomodationPrice);
            }
        }
        if (budget > 100 && budget <= 1000) {
            destination = "Balkans";
            if (season.equals("summer")) {
                accomodationPrice = budget * 0.4;
                accomodationType = "Camp";
                System.out.printf("Somewhere in %s\n", destination);
                System.out.printf("%s - %.2f", accomodationType, accomodationPrice);
            }
            if (season.equals("winter")) {
                accomodationPrice = budget * 0.8;
                accomodationType = "Hotel";
                System.out.printf("Somewhere in %s\n", destination);
                System.out.printf("%s - %.2f", accomodationType, accomodationPrice);
            }

        }
        if (budget > 1000) {
            destination = "Europe";
            if (season.equals("summer") || season.equals("winter")) {
                accomodationPrice = budget * 0.9;
                accomodationType = "Hotel";
                System.out.printf("Somewhere in %s\n", destination);
                System.out.printf("%s - %.2f", accomodationType, accomodationPrice);
            }
        }
    }
}