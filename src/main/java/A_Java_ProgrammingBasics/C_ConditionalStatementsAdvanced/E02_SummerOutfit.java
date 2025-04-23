package A_Java_ProgrammingBasics.C_ConditionalStatementsAdvanced;

import java.util.*;

public class E02_SummerOutfit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double temperature = Double.parseDouble(scanner.nextLine());
        String timeOfDay = scanner.nextLine();
        String outfit = "";
        String shoes = "";

        if (temperature >= 10 && temperature <= 18) {
            if (timeOfDay.equals("Morning")) {
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            } else {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        }
        if (temperature > 18 && temperature <= 24) {
            switch (timeOfDay) {
                case "Morning":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                case "Afternoon":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
            }
        }
        if (temperature >= 25) {
            switch (timeOfDay) {
                case "Morning":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;
                case "Afternoon":
                    outfit = "Swim Suit";
                    shoes = "Barefoot";
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
            }
        }
        System.out.printf("It's %.0f degrees, get your %s and %s.", temperature, outfit, shoes);
    }
}