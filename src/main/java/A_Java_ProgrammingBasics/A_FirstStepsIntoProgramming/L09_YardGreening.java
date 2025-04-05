package A_Java_ProgrammingBasics.A_FirstStepsIntoProgramming;

import java.util.*;

public class L09_YardGreening {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double area = Double.parseDouble(scanner.nextLine());

        double subTotal = area * 7.61;
        double discount = subTotal * 0.18;
        double total = subTotal - discount;
        System.out.printf("The final price is: %f%n lv.", total);
        System.out.printf("The discount is: %f lv.", discount);
    }
}
