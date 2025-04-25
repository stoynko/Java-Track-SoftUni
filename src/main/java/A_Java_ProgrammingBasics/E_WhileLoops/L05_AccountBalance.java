package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class L05_AccountBalance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double balance = 0;

        while (!input.equals("NoMoreMoney")) {
            double deposit = Double.parseDouble(input);
            if (deposit < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            balance += deposit;
            System.out.printf("Increase: %.2f\n", deposit);
            input = scanner.nextLine();
        }
        System.out.printf("Total: %.2f\n", balance);
    }
}
