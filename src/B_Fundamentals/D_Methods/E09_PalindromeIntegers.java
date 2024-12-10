package B_Fundamentals.D_Methods;

import java.util.*;

public class E09_PalindromeIntegers {

/*A palindrome is a number that reads the same backward as forward, such as 323 or 1001.
Write a program that reads a positive integer number until you receive "END".
For each numbered print, whether the number is palindrome or not.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            System.out.println(isNumberPalindrome(input));
            input = scanner.nextLine();
        }
    }

    private static boolean isNumberPalindrome(String input) {
        for (int index = 0; index <= input.length() - 1; index++) {
            if (input.charAt(index) != input.charAt(input.length() - 1 - index)) {
                return false;
            }
        }
        return true;
    }
}