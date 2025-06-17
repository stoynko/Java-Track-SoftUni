package C_ConditionalStatementsAdvanced;

import java.util.*;

public class L08_CinemaTicket {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Friday":
                System.out.println(12);
                break;
            case "Wednesday":
            case "Thursday":
                System.out.println(14);
                break;
            case "Saturday":
            case "Sunday":
                System.out.println(16);
                break;
            default:
                break;

        }
    }
}