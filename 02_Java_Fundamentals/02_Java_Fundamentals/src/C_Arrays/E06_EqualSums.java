package C_Arrays;

import java.util.*;

public class E06_EqualSums {

/*Write a program that determines if an element exists in the array such that the sum of the elements on its left is equal
to the sum of the elements on its right. If there are no elements to the left/right, their sum is considered to be 0.
Print the index that satisfies the required condition or "no" if there is no such index.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isEven = false;

        for (int index = 0; index <= numbers.length - 1; index++) {
            int sumPrecedingElements = 0;
            int sumSucceedingElements = 0;
            for (int position = index + 1; position <= numbers.length - 1; position++) {
                sumSucceedingElements += numbers[position];
            }
            for (int position = index - 1; position >= 0; position--) {
                sumPrecedingElements += numbers[position];
            }
            if (sumPrecedingElements == sumSucceedingElements) {
                isEven = true;
                System.out.println(index);
            }
        }
        if (!isEven) {
            System.out.println("no");
        }
    }
}
