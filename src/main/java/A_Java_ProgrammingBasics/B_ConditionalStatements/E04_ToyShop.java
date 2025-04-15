package A_Java_ProgrammingBasics.B_ConditionalStatements;

import java.util.*;

public class E04_ToyShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double puzzlePrice = 2.6;
        double dollPrice = 3;
        double bearPrice = 4.1;
        double minionPrice = 8.2;
        double truckPrice = 2;
        double tripPrice = Double.parseDouble(scanner.nextLine());

        int puzzlesOrdered = Integer.parseInt(scanner.nextLine());
        int dollsOrdered = Integer.parseInt(scanner.nextLine());
        int bearsOrdered = Integer.parseInt(scanner.nextLine());
        int minionsOrdered = Integer.parseInt(scanner.nextLine());
        int trucksOrdered = Integer.parseInt(scanner.nextLine());
        int itemsOrdered = puzzlesOrdered + dollsOrdered + bearsOrdered + minionsOrdered + trucksOrdered;

        double discount = 0;

        if (itemsOrdered >= 50) {
            discount = 0.25;
        }

        double orderTotal = ((puzzlesOrdered * puzzlePrice) + (dollsOrdered * dollPrice) + (bearsOrdered * bearPrice) +
                (minionsOrdered * minionPrice) + (trucksOrdered * truckPrice)) * (1 - discount);

        double profit = orderTotal - (orderTotal * 0.1);

        if (profit - tripPrice >= 0) {
            System.out.printf("Yes! %.2f lv left.", profit - tripPrice);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", tripPrice - profit);
        }
    }
}
