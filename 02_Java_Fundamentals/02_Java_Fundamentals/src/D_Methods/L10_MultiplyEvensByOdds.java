package D_Methods;

import java.util.*;

public class L10_MultiplyEvensByOdds {

/*Create a program that reads an integer number and multiplies the sum of all its even digits by the sum of all its odd digits*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Math.abs(Integer.parseInt(scanner.nextLine()));
        System.out.println(getSumOdds(input) * getSumEvens(input));
    }

    private static int getSumEvens(int input) {
        int sumEvens = 0;
        while (input != 0) {
            int currentDigit = input % 10;
            if (currentDigit % 2 == 0) {
                sumEvens += currentDigit;
            }
            input /= 10;
        }
        return sumEvens;
    }

    private static int getSumOdds(int input) {
        int sumOdds = 0;
        while (input != 0) {
            int currentDigit = input % 10;
            if (currentDigit % 2 != 0) {
                sumOdds += currentDigit;
            }
            input /= 10;
        }
        return sumOdds;
    }
}