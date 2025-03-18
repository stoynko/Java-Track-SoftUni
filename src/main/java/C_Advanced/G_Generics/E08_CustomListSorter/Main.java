package C_Advanced.G_Generics.E08_CustomListSorter;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        CustomList <String> customList = new CustomList<>();

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
                case "Sort" -> customList.sort();
                case "Print" -> customList.print();
            }
            input = scanner.nextLine();
        }
    }
}
