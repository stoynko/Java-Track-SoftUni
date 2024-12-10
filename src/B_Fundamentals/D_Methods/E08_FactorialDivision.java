package B_Fundamentals.D_Methods;

import java.util.*;

public class E08_FactorialDivision {

/*Read two integer numbers. Calculate the factorial of each number.
Divide the first result by the second and print the division formatted to the second decimal point.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double numberA = Math.abs(Double.parseDouble(scanner.nextLine()));
        double numberB = Math.abs(Double.parseDouble(scanner.nextLine()));
        System.out.printf("%.2f", factorial(numberA) / factorial(numberB));
    }

    private static double factorial(double n) {
        double factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
