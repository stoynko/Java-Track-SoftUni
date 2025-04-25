package A_Java_ProgrammingBasics.F_NestedLoops;

import java.util.*;

public class L05_Travelling {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double budget = 0;

        while (!input.equals("End")) {
            String destination = input;
            budget = Double.parseDouble(scanner.nextLine());
            double amount = 0;
            while (amount < budget) {
                amount += Double.parseDouble(scanner.nextLine());
            }
            System.out.printf("Going to %s!\n", destination);
            input = scanner.nextLine();
        }
    }
}
