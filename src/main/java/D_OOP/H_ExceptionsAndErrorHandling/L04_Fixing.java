package D_OOP.H_ExceptionsAndErrorHandling;

import java.util.*;

public class L04_Fixing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] weekdays = new String[5];

        weekdays[0] = "Monday";
        weekdays[1] = "Tuesday";
        weekdays[2] = "Wednesday";
        weekdays[3] = "Thursday";
        weekdays[4] = "Friday";

        try {
            for (int i = 0; i <= weekdays.length; i++) {

                System.out.println(weekdays[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }
}
