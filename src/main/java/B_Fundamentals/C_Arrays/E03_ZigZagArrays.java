package B_Fundamentals.C_Arrays;

import java.util.*;

public class E03_ZigZagArrays {

/*Write a program that creates 2 arrays. You will be given an integer n.
On the next n lines, you get 2 integers.
Form 2 arrays as shown below.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rowCount = Integer.parseInt(scanner.nextLine());
        int[] arrayA = new int[rowCount]; // 1 10 31 20
        int[] arrayB = new int[rowCount]; // 2 9 81 41

        for (int index = 0; index < rowCount; index++) {
            String input = scanner.nextLine();
            int elementA = Integer.parseInt(input.split(" ")[0]);
            int elementB = Integer.parseInt(input.split(" ")[1]);
            if (index % 2 == 0) {
                arrayA[index] = elementA;
                arrayB[index] = elementB;
            } else {
                arrayA[index] = elementB;
                arrayB[index] = elementA;
            }
        }
        for (int element : arrayA) {
            System.out.printf("%d ", element);
        }
        System.out.printf("%n");
        for (int element : arrayB) {
            System.out.printf("%d ", element);
        }
    }
}
