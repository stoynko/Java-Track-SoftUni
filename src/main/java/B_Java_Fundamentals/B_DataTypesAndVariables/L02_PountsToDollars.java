package B_Java_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class L02_PountsToDollars {

/* Write a program that:
    •	Reads an floating-point number that represents quantity of British pounds for conversion
    •	Convert pounds to dollars (1 British Pound = 1.36 Dollars)
•	Print the resulted dollars, formatted to the third decimal point*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        float inputGBP = Float.parseFloat(scanner.nextLine());

        float outputUSD = inputGBP * 1.36f;

        System.out.printf("%.3f", outputUSD);
    }
}