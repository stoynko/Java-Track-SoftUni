package C_Arrays;

import java.util.*;

public class L03_SumEvenNumbers {

//Read an array from the console and sum only the even numbers.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                sum += number;
            }
        }
        System.out.println(sum);
    }
}
