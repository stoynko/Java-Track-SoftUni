package B_Java_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class E03_Vacation {

/*You are given a group of people, type of the group, on which day of the week they will stay. Based on that information,
calculate how much they must pay and print that price on the console. Use the table below. In each cell is the price for a single person.
The output should look like that: "Total price: {price}". The price should be formatted to the second decimal point.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int groupSize = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        int discount = 0;

        if (groupType.equals("Students")) {
            price = switch (day) {
                case "Friday" -> 8.45;
                case "Saturday" -> 9.8;
                case "Sunday" -> 10.46;
                default -> price;
            };
        } else if (groupType.equals("Business")) {
            price = switch (day) {
                case "Friday" -> 10.9;
                case "Saturday" -> 15.6;
                case "Sunday" -> 16;
                default -> price;
            };
        } else if (groupType.equals("Regular")) {
            price = switch (day) {
                case "Friday" -> 15;
                case "Saturday" -> 20;
                case "Sunday" -> 22.5;
                default -> price;
            };
        }

        if (groupType.equals("Students") && groupSize >= 30) {
            discount = 15;
        } else if (groupType.equals("Business") && groupSize >= 100) {
            groupSize = groupSize - 10;
        } else if (groupType.equals("Regular") && groupSize >= 10 && groupSize <= 20) {
            discount = 5;
        }

        double total = (groupSize * price) - ((groupSize * price) * ((double) discount / 100));

        System.out.printf("Total price: %.2f", total);
    }
}