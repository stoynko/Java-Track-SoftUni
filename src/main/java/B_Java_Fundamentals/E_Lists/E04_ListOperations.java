package B_Java_Fundamentals.E_Lists;

import java.util.*;
import java.util.stream.*;

public class E04_ListOperations {

/*You will be given numbers (a list of integers) on the first input line.
Until you receive "End" you will be given operations you must apply on the list. The possible commands are:

•	Add {number} - add number at the end
•	Insert {number} {index} - insert number at given index
•	Remove {index} - remove that index
•	Shift left {count} - first number becomes last 'count' times
•	Shift right {count} - last number becomes first 'count' times

Note: The index given may be outside the array's bounds. In that case, print "Invalid index".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) { // 1 2 3 4 5
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Add" -> integerList.add(Integer.parseInt(command[1]));
                case "Insert" -> {
                    int index = Integer.parseInt(command[2]);
                    int value = Integer.parseInt(command[1]);
                    if (isIndexValid(integerList.size(), index)) {
                        integerList.add(index, value);
                    } else {
                        System.out.println("Invalid index");
                    }
                }
                case "Remove" -> {
                    int index = Integer.parseInt(command[1]);
                    if (isIndexValid(integerList.size(), index)) {
                        integerList.remove(Integer.parseInt(command[1]));
                    } else {
                        System.out.println("Invalid index");
                    }
                }
                case "Shift" -> {
                    int cyclesCount = Integer.parseInt(command[2]);
                    if (command[1].equals("left")) {
                        shiftListLeft(integerList, cyclesCount);
                    } else if (command[1].equals("right")) {
                        shiftListRight(integerList, cyclesCount);
                    }
                }
            }
            input = scanner.nextLine();

        }
        System.out.println(integerList.toString().replaceAll("[\\[\\],]", ""));
    }

    private static boolean isIndexValid(int listSize, int index) {
        return index >= 0 && index < listSize;
    }

    private static void shiftListLeft(List<Integer> list, int cyclesCount) {
        for (int currentCycle = 1; currentCycle <= cyclesCount; currentCycle++) {
            int temp = list.removeFirst();
            list.add(temp);
        }
    }

    private static void shiftListRight(List<Integer> list, int cyclesCount) {
        for (int currentCycle = 1; currentCycle <= cyclesCount; currentCycle++) {
            int temp = list.remove(list.size() - 1);
            list.add(0, temp);
        }
    }
}