package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class E03_Vacation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double moneyNeeded = Double.parseDouble(scanner.nextLine());
        double moneyAvailable = Double.parseDouble(scanner.nextLine());
        int spendCounter = 0;
        int dayCounter = 0;

        while (true) {
            String action = scanner.nextLine();
            double amount = Double.parseDouble(scanner.nextLine());
            dayCounter++;

            if (action.equals("spend")) {
                spendCounter++;
                if (spendCounter == 5) {
                    System.out.println("You can't save the money.");
                    System.out.printf("%d\n", dayCounter);
                    break;
                }
                moneyAvailable -= amount;
                if (moneyAvailable < 0) {
                    moneyAvailable = 0;
                }
            }

            if (action.equals("save")) {
                spendCounter = 0;
                moneyAvailable += amount;
                if (moneyAvailable >= moneyNeeded) {
                    System.out.printf("You saved the money for %d days.\n", dayCounter);
                    break;
                }
            }
        }
    }
}
