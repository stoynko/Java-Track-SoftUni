package B_Java_Fundamentals.C_Arrays;

import java.util.*;

public class E08_MagicSum {

//Write a program that prints all unique pairs in an array of integers whose sum is equal to a given number.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(scanner.nextLine());

        for (int primaryIndex = 0; primaryIndex <= numbers.length - 1; primaryIndex++) {
            for (int secondaryIndex = primaryIndex + 1; secondaryIndex <= numbers.length - 1; secondaryIndex++) {
                if (numbers[primaryIndex] + numbers[secondaryIndex] == target) {
                    System.out.printf("%d %d\n", numbers[primaryIndex], numbers[secondaryIndex]);
                }
            }
        }
    }
}
