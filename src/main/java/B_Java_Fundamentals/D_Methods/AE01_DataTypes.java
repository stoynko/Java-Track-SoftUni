package B_Java_Fundamentals.D_Methods;

import java.util.*;

public class AE01_DataTypes {

/*Write a program that, depending on the first line of the input, reads an int, double, or string.
    •	If the data type is int, multiply the number by 2.
    •	If the data type is real, multiply the number by 1.5 and format it to the second decimal point.
    •	If the data type is a string, surround the input with "$".
Print the result on the console.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "int" -> readIntAndOutputResult(scanner);
            case "real" -> readDoubleAndOutputResult(scanner);
            case "string" -> readStringAndOutputResult(scanner);
        }
    }

    private static void readIntAndOutputResult(Scanner scanner) {
        int integer = Integer.parseInt(scanner.nextLine());
        int result = integer * 2;
        System.out.println(result);
    }

    private static void readDoubleAndOutputResult(Scanner scanner) {
        double integer = Double.parseDouble(scanner.nextLine());
        double result = integer * 1.5;
        System.out.printf("%.2f", result);
    }

    private static void readStringAndOutputResult(Scanner scanner) {
        String input = scanner.nextLine();
        System.out.printf("$%s$", input);
    }
}