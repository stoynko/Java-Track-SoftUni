package B_Fundamentals.E_Lists;

import java.util.*;
import java.util.stream.*;

public class L04_ListManipulationAdvanced {

/*Now we will implement more complicated list commands. Again, read a list, and until you receive "end" read commands:
    •	Contains {number} – check if the list contains the number. If yes, print "Yes", otherwise, print ""
    •	Print even – print all the numbers that are even separated by a space
    •	Print odd – print all the numbers that are oddly separated by a space
    •	Get sum – print the sum of all the numbers
    •	Filter {condition} {number} – print all the numbers that fulfill that condition. The condition will be either '<', '>', ">=", "<="*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Contains" -> {
                    if (integerList.contains(Integer.parseInt(command[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                }
                case "Print" -> {
                    if (command[1].equals("even")) {
                        List<Integer> integersEven = new ArrayList<>();
                        for (int integer : integerList) {
                            if (integer % 2 == 0) {
                                integersEven.add(integer);
                            }
                        }
                        System.out.println(integersEven.toString().replaceAll("[\\[\\],]", "").trim());
                    } else {
                        List<Integer> integersOdd = new ArrayList<>();
                        for (int integer : integerList) {
                            if (integer % 2 != 0) {
                                integersOdd.add(integer);
                            }
                        }
                        System.out.println(integersOdd.toString().replaceAll("[\\[\\],]", "").trim());
                    }
                }
                case "Get" -> {
                    int sum = 0;
                    for (int integer : integerList) {
                        sum += integer;
                    }
                    System.out.println(sum);
                }
                case "Filter" -> {
                    List<Integer> filteredIntegers = new ArrayList<>();
                    switch (command[1]) {
                        case "<" -> {
                            int comparator = Integer.parseInt(command[2]);
                            for (int integer : integerList) {
                                if (integer < comparator) {
                                    filteredIntegers.add(integer);
                                }
                            }
                        }
                        case ">" -> {
                            int comparator = Integer.parseInt(command[2]);
                            for (int integer : integerList) {
                                if (integer > comparator) {
                                    filteredIntegers.add(integer);
                                }
                            }
                        }
                        case "<=" -> {
                            int comparator = Integer.parseInt(command[2]);
                            for (int integer : integerList) {
                                if (integer <= comparator) {
                                    filteredIntegers.add(integer);
                                }
                            }
                        }
                        case ">=" -> {
                            int comparator = Integer.parseInt(command[2]);
                            for (int integer : integerList) {
                                if (integer >= comparator) {
                                    filteredIntegers.add(integer);
                                }
                            }
                        }
                    }
                    System.out.println(filteredIntegers.toString().replaceAll("[\\[\\],]", "").trim());
                }
            }

            input = scanner.nextLine();
        }
    }
}