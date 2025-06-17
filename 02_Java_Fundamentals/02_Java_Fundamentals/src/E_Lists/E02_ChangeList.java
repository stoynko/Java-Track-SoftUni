package E_Lists;

import java.util.*;
import java.util.stream.*;

public class E02_ChangeList {

/*Write a program that reads a list of integers from the console and receives commands which manipulate the list. Your program may receive the following commands:
    •	Delete {element} - delete all elements in the array which are equal to the given element
    •	Insert {element} {position} - insert element at the given position

You should stop the program when you receive the command "end". Print all numbers in the array, separated with a single whitespace.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] action = input.split(" ");
            if (action[0].equals("Insert")) {
                integers.add(Integer.parseInt(action[2]), Integer.parseInt(action[1]));
            } else if (action[0].equals("Delete")) {
                while (integers.contains(Integer.parseInt(action[1]))) {
                    integers.remove(Integer.valueOf(action[1]));
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(integers.toString().replaceAll("[\\[\\],]", ""));
    }
}