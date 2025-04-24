package A_Java_ProgrammingBasics.C_ConditionalStatementsAdvanced;

import java.util.*;

public class E08_OnTimeForTheExam {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int hourStart = Integer.parseInt(scanner.nextLine());
        int minuteStart = Integer.parseInt(scanner.nextLine());
        int hourArrival = Integer.parseInt(scanner.nextLine());
        int minuteArrival = Integer.parseInt(scanner.nextLine());
        int hour = 0;
        int minute = 0;

        int totalStart = (hourStart * 60) + minuteStart;
        int totalArrival = (hourArrival * 60) + minuteArrival;

        if (totalArrival > totalStart) {
            int resultTime = (totalArrival - totalStart);
            System.out.println("Late");
            if (resultTime < 60) {
                System.out.printf("%d minutes after the start", resultTime);
            } else {
                hour = resultTime / 60;
                minute = resultTime % 60;

                if (minute < 10) {
                    System.out.printf("%d:0%d hours after the start", hour, minute);
                } else
                    System.out.printf("%d:%d hours after the start", hour, minute);
            }
        } else if (totalArrival < totalStart) {
            int resultTime = totalStart - totalArrival;
            hour = resultTime / 60;
            minute = resultTime % 60;

            if (resultTime >= 60) {
                System.out.println("Early");
                if (minute < 10) {
                    System.out.printf("%d:0%d hours before the start", hour, minute);
                } else
                    System.out.printf("%d:%d hours before the start", hour, minute);
            } else if (resultTime > 30 && resultTime < 60) {
                System.out.println("Early");
                System.out.printf("%d minutes before the start", minute);
            } else if (resultTime <= 30) {
                System.out.println("On time");
                System.out.printf("%d minutes before the start", minute);
            }
        } else
            System.out.println("On time");
    }
}