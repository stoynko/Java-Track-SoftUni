package B_Fundamentals.C_Arrays;

import java.util.*;

public class L05_EvenAndOddSubstraction {

//Write a program that calculates the difference between the sum of the even and the sum of the odd numbers in an array.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sumEven = 0;
        int sumOdd = 0;

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] % 2 == 0) {
                sumEven += numbers[index];
            } else {
                sumOdd += numbers[index];
            }
        }
        System.out.println(sumEven - sumOdd);
    }
}