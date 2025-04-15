package A_Java_ProgrammingBasics.C_ConditionalStatementsAdvanced;

import java.util.*;

public class L04_PersonalTitles {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double age = Double.parseDouble(scanner.nextLine());
        char gender = scanner.nextLine().charAt(0);

        switch (gender) {
            case 'm':
                if (age >= 16) {
                    System.out.println("Mr.");
                    break;
                } else {
                    System.out.println("Master");
                    break;
                }
            case 'f':
                if (age >= 16) {
                    System.out.println("Ms.");
                    break;
                } else {
                    System.out.println("Miss");
                    break;
                }
            default:
                break;
        }
    }
}
