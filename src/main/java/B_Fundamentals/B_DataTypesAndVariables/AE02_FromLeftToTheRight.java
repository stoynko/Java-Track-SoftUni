package B_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class AE02_FromLeftToTheRight {

/*You will receive a number representing how many lines we will get as input. On the next N lines, you will receive a string with 2 numbers separated by a single space.
You need to compare them. If the left number is greater than the right number, you need to print the sum of all digits in the left number, otherwise,
print the sum of all digits in the right number.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rowsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= rowsCount; i++) {
            long sum = 0;
            long numberA = scanner.nextLong();
            long numberB = scanner.nextLong();
            scanner.nextLine();
            if (numberA > numberB) {

                while (numberA != 0) {
                    sum += numberA % 10;
                    numberA = numberA / 10;
                }
            } else {
                while (numberB != 0) {
                    sum += numberB % 10;
                    numberB = numberB / 10;
                }
            }

            System.out.println(Math.abs(sum));
        }
    }
}