package B_Fundamentals.C_Arrays;

import java.util.*;

public class E07_CondenseArrayToNumber {

/*Write a program to read an array of integers and condense them by summing adjacent couples of elements until a single integer is obtained.
For example, if we have 3 elements {2, 10, 3}, we sum the first two and the second two elements and obtain {2+10, 10+3} = {12, 13},
then we sum again all adjacent elements and obtain {12+13} = {25}.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        while (numbers.length != 1) {
            int[] condensed = new int[numbers.length - 1];

            for (int index = 0; index <= condensed.length - 1; index++) {
                condensed[index] = numbers[index] + numbers[index + 1];
            }

            numbers = new int[condensed.length];

            for (int index = 0; index <= numbers.length - 1; index++) {
                numbers[index] = condensed[index];
            }
        }
        System.out.println(numbers[0]);
    }
}
