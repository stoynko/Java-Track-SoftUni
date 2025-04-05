package B_Java_Fundamentals.E_Lists;

import java.util.*;
import java.util.stream.*;

public class L01_ListManipulationBasics {

/*Write a program that reads a list of integers. Then until you receive "end",
you will be given different commands:

    •	Add {number} – add a number to the end of the list
    •	Remove {number} – remove a number from the list
    •	RemoveAt {index} – remove a number at a given index
    •	Insert {number} {index} – insert a number at a given index

Note: All the indices will be valid!

When you receive the "end" command, print the final state of the list (separated by spaces).*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> integers = new ArrayList<>();
        integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Add" -> integers.add(Integer.parseInt((command[1])));
                case "Remove" -> integers.remove(Integer.valueOf(command[1]));
                case "RemoveAt" -> integers.remove(Integer.parseInt(command[1]));
                case "Insert" -> integers.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
            }
            input = scanner.nextLine();
        }
        for (int integer : integers) {
            System.out.print(integer + " ");
        }
    }
}