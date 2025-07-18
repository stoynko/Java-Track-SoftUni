package C_ConditionalStatementsAdvanced;

import java.util.*;

public class L02_WeekendOrWorkingDay {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();

        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                System.out.println("Working day");
                break;
            case "Saturday":
            case "Sunday":
                System.out.println("Weekend");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
}
