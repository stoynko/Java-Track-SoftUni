package A_Java_ProgrammingBasics.C_ConditionalStatementsAdvanced;

import java.util.*;

public class E07_HotelRoom {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int period = Integer.parseInt(scanner.nextLine());
        double priceStudioNight = 0;
        double priceApartmentNight = 0;
        double discountStudio = 0;
        double discountApartment = 0;

        if (month.equals("May") || month.equals("October")) {
            priceStudioNight = 50;
            priceApartmentNight = 65;
            if (period > 7 && period <= 14) {
                discountStudio = 5;
            } else if (period > 14) {
                discountStudio = 30;
                discountApartment = 10;
            }
        } else if (month.equals("June") || month.equals("September")) {
            priceStudioNight = 75.20;
            priceApartmentNight = 68.70;
            if (period > 14) {
                discountStudio = 20;
                discountApartment = 10;
            }
        } else if (month.equals("July") || month.equals("August")) {
            priceStudioNight = 76;
            priceApartmentNight = 77;
            if (period > 14) {
                discountApartment = 10;
            }
        }
        double totalApartment = (priceApartmentNight * period) - ((priceApartmentNight * period) * (discountApartment / 100));
        double totalStudio = (priceStudioNight * period) - ((priceStudioNight * period) * (discountStudio / 100));
        System.out.printf("Apartment: %.2f lv.\n", totalApartment);
        System.out.printf("Studio: %.2f lv.", totalStudio);
    }
}