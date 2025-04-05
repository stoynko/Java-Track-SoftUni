package B_Java_Fundamentals.D_Methods;

import java.util.*;

public class L04_Calculations {

/*Write a program that receives a string on the first line ("add", "multiply", "subtract", "divide") and on the next two lines receives two numbers.
Create four methods (for each calculation) and invoke the right one depending on the command. The method should also print the result (it needs to be void).*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int digitA = Integer.parseInt(scanner.nextLine());
        int digitB = Integer.parseInt(scanner.nextLine());

        switch (input) {
            case "add":
                add(digitA, digitB);
                break;
            case "subtract":
                subtract(digitA, digitB);
                break;
            case "multiply":
                multiply(digitA, digitB);
                break;
            case "divide":
                divide(digitA, digitB);
                break;
        }

    }

    private static void add(int digitA, int digitB) {
        System.out.println(digitA + digitB);
    }

    private static void subtract(int digitA, int digitB) {
        System.out.println(digitA - digitB);
    }

    private static void multiply(int digitA, int digitB) {
        System.out.println(digitA * digitB);
    }

    private static void divide(int digitA, int digitB) {
        System.out.println(digitA / digitB);
    }
}