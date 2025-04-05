package B_Java_Fundamentals.D_Methods;

import java.util.*;

public class E10_TopNumber {

/*Read an integer n from the console. Find all top numbers in the range [1 … n] and print them.
A top number holds the following properties:
    •	Its sum of digits is divisible by 8, e.g. 8, 16, 88.
    •	Holds at least one odd digit, e.g. 232, 707, 87578.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int endRange = Integer.parseInt(scanner.nextLine());

        for (int position = 1; position < endRange; position++) {
            String currentNumber = String.valueOf(position);
            if (isDividable(currentNumber)) {
                if (containsOddDigit(currentNumber)) {
                    System.out.println(currentNumber);
                }
            }
        }
    }

    private static int[] toIntegerArray(String number) {
        int[] digits = new int[number.length()];
        for (int digitsIndex = 0; digitsIndex < number.length(); digitsIndex++) {
            digits[digitsIndex] = Integer.parseInt(String.valueOf(number.charAt(digitsIndex)));
        }
        return digits;
    }

    private static boolean isDividable(String currentNumber) {
        int[] digits = toIntegerArray(currentNumber);
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum % 8 == 0;
    }

    private static boolean containsOddDigit(String currentNumber) {
        int[] digits = toIntegerArray(currentNumber);
        for (int digit : digits) {
            if (digit % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}