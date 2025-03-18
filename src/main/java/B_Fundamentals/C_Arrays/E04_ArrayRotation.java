package B_Fundamentals.C_Arrays;

import java.util.*;

public class E04_ArrayRotation {

/*Write a program that receives an array and the number of rotations you have to perform (the first element goes at the end).
Print the resulting array.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= rotations; i++) {
            int temp = array[0];
            for (int index = 0; index <= array.length - 1; index++) {
                if (index == array.length - 1) {
                    array[index] = temp;
                } else {
                    array[index] = array[index + 1];
                }
            }
        }
        for (int element : array) {
            System.out.printf("%d ", element);
        }
    }
}