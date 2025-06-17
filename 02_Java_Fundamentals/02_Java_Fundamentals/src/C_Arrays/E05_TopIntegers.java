package C_Arrays;

import java.util.*;

public class E05_TopIntegers {

    public static void main(String[] args) {

/*Write a program to find all the top integers in an array.
A top integer is an integer that is bigger than all the elements to its right.*/

        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int index = 0; index < numbers.length - 1; index++) {
            boolean isBigger = false;
            if (numbers[index] > numbers[index + 1]) {
                for (int j = index + 1; j <= numbers.length - 1; j++) {
                    if (numbers[index] > numbers[j]) {
                        isBigger = true;
                    } else {
                        isBigger = false;
                        break;
                    }
                }
                if (isBigger) {
                    System.out.printf("%d ", numbers[index]);
                }
            }
        }
        System.out.printf("%d", numbers[numbers.length - 1]);
    }
}
