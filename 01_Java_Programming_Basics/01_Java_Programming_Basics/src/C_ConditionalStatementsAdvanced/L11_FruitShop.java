package C_ConditionalStatementsAdvanced;

import java.util.*;

public class L11_FruitShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        if (day.equals("Workday")) {
            System.out.println("error");
        }
        switch (fruit) {
            case "banana":
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    double price = 2.5;
                    System.out.printf("%.2f", quantity * 2.5);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    System.out.printf("%.2f", quantity * 2.7);
                }
                break;
            case "apple":
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    System.out.printf("%.2f", quantity * 1.2);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    System.out.printf("%.2f", quantity * 1.25);
                }
                break;
            case "orange":
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    System.out.printf("%.2f", quantity * 0.85);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    System.out.printf("%.2f", quantity * 0.9);
                }
                break;
            case "grapefruit":
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    System.out.printf("%.2f", quantity * 1.45);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    System.out.printf("%.2f", quantity * 1.6);
                }
                break;
            case "kiwi":
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    System.out.printf("%.2f", quantity * 2.7);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    System.out.printf("%.2f", quantity * 3);
                }
                break;
            case "pineapple":
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    System.out.printf("%.2f", quantity * 5.5);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    System.out.printf("%.2f", quantity * 5.6);
                }
                break;
            case "grapes":
                if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
                    System.out.printf("%.2f", quantity * 3.85);
                } else if (day.equals("Saturday") || day.equals("Sunday")) {
                    System.out.printf("%.2f", quantity * 4.2);
                }
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}