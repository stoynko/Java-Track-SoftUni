package B_Fundamentals.D_Methods;

import java.util.*;

public class L09_GreaterOfTwoValues {

/*You are given two values of the same type as input. The values can be of type int, char of String.
Create a method getMax() that returns the greater of the two values.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String comparatorA = scanner.nextLine();
        String comparatorB = scanner.nextLine();

        if (input.equals("int")) {
            int numberA = Integer.parseInt(comparatorA);
            int numberB = Integer.parseInt(comparatorB);
            System.out.println(getMaxInteger(numberA, numberB));
        } else {
            System.out.println(getMaxString(input, comparatorA, comparatorB));
        }
    }

    private static int getMaxInteger(int numberA, int numberB) {
        return Math.max(numberA, numberB);
    }

    private static String getMaxString(String input, String comparatorA, String comparatorB) {
        String result = "";
        if (input.equals("char")) {
            char charA = comparatorA.charAt(0);
            char charB = comparatorB.charAt(0);

            if (charA > charB) {
                result = String.valueOf(charA);
            } else {
                result = String.valueOf(charB);
            }
            return result;
        } else {
            if (comparatorA.compareTo(comparatorB) > 0) {
                result = comparatorA;
            } else if (comparatorA.compareTo(comparatorB) < 0) {
                result = comparatorB;
            }
            return result;
        }
    }
}
