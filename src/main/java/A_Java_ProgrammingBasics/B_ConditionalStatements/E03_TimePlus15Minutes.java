package A_Java_ProgrammingBasics.B_ConditionalStatements;

import java.util.*;

public class E03_TimePlus15Minutes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int newMin = 0;

        int timeAfter = minutes + 15;
        if (timeAfter >= 60) {
            newMin = timeAfter - 60;
            hour++;
            if (hour > 23)
                hour = 0;
        } else
            newMin = minutes + 15;
        if (newMin < 10)
            System.out.printf("%d:0%d", hour, newMin);
        else
            System.out.printf("%d:%d", hour, newMin);
    }
}