package B_Java_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class L01_ConvertMetersToKilometers {

/*Write a program that:
    •	Reads an integer number that represents meters for conversion
    •	Convert meters to kilometers (1000 meters = 1 kilometer)
    •	Print the resulted kilometers, formatted to the second decimal point*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int meters = Integer.parseInt(scanner.nextLine());

        double kilometers = meters / 1000.0;

        System.out.printf("%.2f", kilometers);
    }
}
