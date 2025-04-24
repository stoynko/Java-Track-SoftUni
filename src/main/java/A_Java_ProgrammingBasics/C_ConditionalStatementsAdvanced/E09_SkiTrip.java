package A_Java_ProgrammingBasics.C_ConditionalStatementsAdvanced;

import java.util.*;

public class E09_SkiTrip {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double days = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String feedback = scanner.nextLine();

        double price = 0;
        double discount = 0;
        double subTotal = 0;
        double total = 0;
        days--;

        switch (type) {
            case "room for one person":
                price = 18;
                break;
            case "apartment":
                price = 25;
                if (days < 10) {
                    discount = 0.3;
                } else if (days > 15) {
                    discount = 0.5;
                } else {
                    discount = 0.35;
                }
                break;
            case "president apartment":
                price = 35;
                if (days < 10) {
                    discount = 0.1;
                } else if (days > 15) {
                    discount = 0.2;
                } else {
                    discount = 0.15;
                }
                break;
        }
        if (feedback.equals("positive")) {
            total = ((days * price) - ((days * price) * discount)) + (((days * price) - ((days * price) * discount)) * 0.25);
        } else
            total = ((days * price) - ((days * price) * discount)) - (((days * price) - ((days * price) * discount)) * 0.1);

        System.out.printf("%.2f", total);
    }
}