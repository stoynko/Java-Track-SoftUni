package A_Java_ProgrammingBasics.C_ConditionalStatementsAdvanced;

import java.util.*;

public class E01_Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String projectionType = scanner.nextLine();
        double rows = Double.parseDouble(scanner.nextLine());
        double columns = Double.parseDouble(scanner.nextLine());

        switch (projectionType) {
            case "Premiere":
                System.out.printf("%.2f", 12 * (rows * columns));
                break;
            case "Normal":
                System.out.printf("%.2f", 7.5 * (rows * columns));
                break;
            case "Discount":
                System.out.printf("%.2f", 5 * (rows * columns));
                break;
        }
    }
}
