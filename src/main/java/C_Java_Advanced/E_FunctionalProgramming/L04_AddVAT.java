package C_Java_Advanced.E_FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class L04_AddVAT {

/*Write a program that reads one line of Double prices separated by ", ". Print the prices with added VATs for all of them.
Format them to the 2nd digit after the decimal point. The order of the prices must remain the same. Use an UnaryOperator<Double>.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UnaryOperator<Double> funcVATaddition = e -> e + (e * 0.2);
        List<Double> prices = Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble).toList();

        System.out.println("Prices with VAT:");
        prices.stream().map(funcVATaddition::apply).forEach(e -> System.out.printf("%.2f\n", e));
    }
}
