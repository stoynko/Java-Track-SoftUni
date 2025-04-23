package A_Java_ProgrammingBasics.C_ConditionalStatementsAdvanced;

import java.util.*;

public class E06_OperationsBetweenNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        String operation = scanner.nextLine();
        String result = "";

        switch (operation) {
            case "+":
                if ((a + b) % 2 == 0) {
                    result = "even";
                } else
                    result = "odd";
                System.out.printf("%.0f %s %.0f = %.0f - %s", a, operation, b, a + b, result);
                break;

            case "-":
                if ((a - b) % 2 == 0) {
                    result = "even";
                } else
                    result = "odd";
                System.out.printf("%.0f %s %.0f = %.0f - %s", a, operation, b, a - b, result);
                break;

            case "*":
                if ((a * b) % 2 == 0) {
                    result = "even";
                } else
                    result = "odd";

                System.out.printf("%.0f %s %.0f = %.0f - %s", a, operation, b, a * b, result);
                break;

            case "/":
                if (b != 0) {
                    System.out.printf("%.0f %s %.0f = %.2f", a, operation, b, a / b);

                } else
                    System.out.printf("Cannot divide %.0f by zero", a);
                break;

            case "%":
                if (b != 0) {
                    System.out.printf("%.0f %s %.0f = %.0f", a, operation, b, a % b);

                } else
                    System.out.printf("Cannot divide %.0f by zero", a);
                break;
        }
    }
}