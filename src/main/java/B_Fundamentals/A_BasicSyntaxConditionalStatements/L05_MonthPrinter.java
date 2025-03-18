package B_Fundamentals.A_BasicSyntaxConditionalStatements;

import java.util.*;

public class L05_MonthPrinter {

/*Write a program that:
    •	Reads an integer from the console
    •	Print the corresponding month:
        o	1 -> "January"
        o	2 -> "February"
        o	3 -> "March"
        o	4 -> "April"
        o	5 -> "May"
        o	6 -> "June"
        o	7 -> "July"
        o	8 -> "August"
        o	9 -> "September"
        o	10 -> "October"
        o	11 -> "November"
        o	12 -> "December"
Print "Error!", if the number is more than 12 or less than 1*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int digit = Integer.parseInt(scanner.nextLine());

        String month = switch (digit) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Error!";
        };
        System.out.printf("%s", month);
    }
}
