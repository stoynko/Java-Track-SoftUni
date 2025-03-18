package B_Fundamentals.D_Methods;

import java.text.*;
import java.util.*;

public class L08_MathPower {

    /*Create a method that calculates and returns the value of a number raised to a given power*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double number = Integer.parseInt(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        String result = new DecimalFormat("0").format(GetPowerOfNum(number, power));
        System.out.println(result);
    }

    private static double GetPowerOfNum(double number, int power) {
        double result = 1;
        result = Math.pow(number, power);
        return result;
    }
}