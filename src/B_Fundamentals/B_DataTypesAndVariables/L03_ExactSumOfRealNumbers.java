package B_Fundamentals.B_DataTypesAndVariables;

import java.math.*;
import java.util.*;

public class L03_ExactSumOfRealNumbers {

//Write a program to enter n numbers and calculate and print their exact sum (without rounding).

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = new BigDecimal("0");

        for (int i = 1; i <= n; i++) {
            BigDecimal currentNum = new BigDecimal(scanner.nextLine());
            sum = sum.add(currentNum);
        }
        System.out.println(sum);
    }
}