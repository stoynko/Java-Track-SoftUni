package B_DataTypesAndVariables;

import java.util.*;

public class L09_CenturiesToMinutes {

/*Write a program to enter an integer number of centuries and convert it to years, days, hours, and minutes.
Example: 1 century = 100 years = 36524 days = 876581 hours = 52594877 minutes*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        byte centuries = Byte.parseByte(scanner.nextLine());
        short years = (short) (centuries * 100);
        double days = years * 365.2422;
        double hours = days * 24;
        double minutes = hours * 60;

        System.out.printf("%d centuries = %d years = %.0f days = %.0f hours = %.0f minutes", centuries, years, days, hours, minutes);
    }
}