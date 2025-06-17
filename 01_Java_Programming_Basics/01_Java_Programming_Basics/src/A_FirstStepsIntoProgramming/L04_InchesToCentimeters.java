package A_FirstStepsIntoProgramming;

import java.util.*;

public class L04_InchesToCentimeters {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double input = Double.parseDouble(scanner.nextLine());
        double result = input * 2.54;

        System.out.println(result);
    }
}
