package C_ConditionalStatementsAdvanced;

import java.util.*;

public class L05_SmallShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double amount = Double.parseDouble(scanner.nextLine());

        switch (product) {
            case "coffee":
                if (city.equals("Sofia")) {
                    double price = 0.5;
                    System.out.println(price * amount);
                } else if (city.equals("Plovdiv")) {
                    double price = 0.4;
                    System.out.println(price * amount);
                } else if (city.equals("Varna")) {
                    double price = 0.45;
                    System.out.println(price * amount);
                }
                break;
            case "water":
                if (city.equals("Sofia")) {
                    double price = 0.8;
                    System.out.println(price * amount);
                } else if (city.equals("Plovdiv")) {
                    double price = 0.7;
                    System.out.println(price * amount);
                } else if (city.equals("Varna")) {
                    double price = 0.7;
                    System.out.println(price * amount);
                }
                break;
            case "beer":
                if (city.equals("Sofia")) {
                    double price = 1.2;
                    System.out.println(price * amount);
                } else if (city.equals("Plovdiv")) {
                    double price = 1.15;
                    System.out.println(price * amount);
                } else if (city.equals("Varna")) {
                    double price = 1.1;
                    System.out.println(price * amount);
                }
                break;
            case "sweets":
                if (city.equals("Sofia")) {
                    double price = 1.45;
                    System.out.println(price * amount);
                } else if (city.equals("Plovdiv")) {
                    double price = 1.30;
                    System.out.println(price * amount);
                } else if (city.equals("Varna")) {
                    double price = 1.35;
                    System.out.println(price * amount);
                }
                break;
            case "peanuts":
                if (city.equals("Sofia")) {
                    double price = 1.60;
                    System.out.println(price * amount);
                } else if (city.equals("Plovdiv")) {
                    double price = 1.50;
                    System.out.println(price * amount);
                } else if (city.equals("Varna")) {
                    double price = 1.55;
                    System.out.println(price * amount);
                }
                break;
            default:
                break;
        }
    }
}
