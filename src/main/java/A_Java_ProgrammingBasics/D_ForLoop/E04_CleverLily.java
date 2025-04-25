package A_Java_ProgrammingBasics.D_ForLoop;

import java.util.*;

public class E04_CleverLily {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double priceW = Double.parseDouble(scanner.nextLine());
        int priceToy = Integer.parseInt(scanner.nextLine());
        int toyCount = 0;
        double money = 0;

        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                money += (10 * i) / 2;
                money -= 1;
            } else
                toyCount++;
        }
        money += toyCount * priceToy;
        if (money >= priceW) {
            System.out.printf("Yes! %.2f", money - priceW);
        } else
            System.out.printf("No! %.2f", priceW - money);
    }
}
