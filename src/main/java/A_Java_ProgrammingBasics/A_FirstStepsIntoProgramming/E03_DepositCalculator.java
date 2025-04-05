package A_Java_ProgrammingBasics.A_FirstStepsIntoProgramming;

import java.util.*;

public class E03_DepositCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double amount = Double.parseDouble(scanner.nextLine());
        int period = Integer.parseInt(scanner.nextLine());
        double percentage = Double.parseDouble(scanner.nextLine());

        double apr = percentage / amount;
        double total = amount + period * ((amount * apr) / 12);

        System.out.println(total);
    }
}
