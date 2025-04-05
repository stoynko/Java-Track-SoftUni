package B_Java_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class L04_TimeAfterThirty {

/* Write a program that:
    •	Reads two integer numbers: current hours and current minutes
    •	Calculate time after 30 minutes
    •	Print on the console calculated time in the format "hh:mm"

Note: The hours have one or two digits, and the minutes always have two digits (with leading zero).

Constraints:
    •	The current hours will be between 0 and 23.
    •	The current minutes will be between 0 and 59.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        if (minutes + 30 > 59) {
            hour++;
            if (hour > 23) {
                hour = 0;
            }
            minutes = (minutes + 30) - 60;
        } else
            minutes = minutes + 30;
        System.out.printf("%d:%02d", hour, minutes);
    }
}
