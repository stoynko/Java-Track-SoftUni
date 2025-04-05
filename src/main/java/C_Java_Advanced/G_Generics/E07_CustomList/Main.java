package C_Java_Advanced.G_Generics.E07_CustomList;

import java.util.*;

public class Main {

/*Create a generic data structure that can store any type that can be compared. Implement functions:

•	void add(T element)
•	T remove(int index)
•	boolean contains(T element)
•	void swap(int index, int index)
•	int countGreaterThan(T element)
•	T getMax()
•	T getMin()

Create a command interpreter that reads commands and modifies the custom list that you have created. Implement the commands:

•	Add {element} - Adds the given element to the end of the list.
•	Remove {index} - Removes the element at the given index.
•	Contains {element} - Prints if the list contains the given element (true or false).
•	Swap {index1} {index2} - Swaps the elements at the given indexes.
•	Greater {element} - Counts the elements that are greater than the given element and prints their count
•	Max - Prints the maximum element in the list.
•	Min - Prints the minimum element in the list.
•	Print - Prints all elements in the list, each on a separate line.
•	END - stops the reading of commands.
Note: For the Judge tests, use String as T.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();

        while (!input.equals("END")) {

            String[] inputData = input.split(" ");

            switch (inputData[0]) {
                case "Add" -> customList.add(inputData[1]);
                case "Remove" -> customList.remove(Integer.parseInt(inputData[1]));
                case "Contains" -> System.out.println(customList.contains(inputData[1]));
                case "Swap" -> customList.swap(Integer.parseInt(inputData[1]), Integer.parseInt(inputData[2]));
                case "Greater" -> System.out.println(customList.countGreaterThan(inputData[1]));
                case "Max" -> System.out.println(customList.getMax());
                case "Min" -> System.out.println(customList.getMin());
                case "Print" -> customList.print();
            }
            input = scanner.nextLine();
        }
    }
}
