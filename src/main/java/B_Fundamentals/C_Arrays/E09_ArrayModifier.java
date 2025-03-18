package B_Fundamentals.C_Arrays;

import java.util.*;

public class E09_ArrayModifier {

/*You are given an array with integers. Write a program to modify the elements after receiving the following commands:
    •	"swap {index1} {index2}" takes two elements and swap their places.
    •	"multiply {index1} {index2}" takes the element at the 1st index and multiplies it with the element at 2nd index.

Save the product at the 1st index.
    •	"decrease" decreases all elements in the array with 1.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commands = input.split(" ");

            if (commands[0].equals("decrease")) {
                for (int index = 0; index <= numbers.length - 1; index++) {
                    numbers[index]--;
                }
            } else {
                int targetA = Integer.parseInt(commands[1]);
                int targetB = Integer.parseInt(commands[2]);

                if (commands[0].equals("swap")) {
                    int temp = numbers[targetA];
                    numbers[targetA] = numbers[targetB];
                    numbers[targetB] = temp;

                } else if (commands[0].equals("multiply")) {
                    numbers[targetA] *= numbers[targetB];
                }
            }
            input = scanner.nextLine();
        }
        for (int index = 0; index <= numbers.length - 1; index++) {
            if (index != numbers.length - 1) {
                System.out.printf("%d, ", numbers[index]);
            } else {
                System.out.printf("%d", numbers[index]);
            }
        }
    }
}