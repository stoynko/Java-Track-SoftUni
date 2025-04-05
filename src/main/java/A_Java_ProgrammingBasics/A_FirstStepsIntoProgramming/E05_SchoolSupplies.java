package A_Java_ProgrammingBasics.A_FirstStepsIntoProgramming;

import java.util.*;

public class E05_SchoolSupplies {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        double penPrice = 5.8;
        double markerPrice = 7.2;
        double cleanerPrice = 1.2;

        int pensNeeded = Integer.parseInt(scanner.nextLine());
        int markersNeeded = Integer.parseInt(scanner.nextLine());
        int cleanerNeeded = Integer.parseInt(scanner.nextLine());
        double discount = (Double.parseDouble(scanner.nextLine())) / 100;

        double subTotal = (penPrice * pensNeeded) + (markerPrice * markersNeeded) +
                (cleanerPrice * cleanerNeeded);

        double total = subTotal - (subTotal * discount);
        System.out.println(total);
    }
}
