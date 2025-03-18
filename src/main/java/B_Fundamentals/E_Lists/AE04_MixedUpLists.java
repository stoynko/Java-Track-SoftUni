package B_Fundamentals.E_Lists;

import java.util.*;
import java.util.stream.*;

public class AE04_MixedUpLists {

/*Write a program that mixes up two lists by some rules. You will receive two lines of input, each one being a list of numbers. The mixing rules are:
    •	Start from the beginning of the first list and the ending of the second.
    •	Add element from the first and element from the second.
    •	In the end, there will always be a list in which there are 2 elements remaining.
    •	These elements will be the range of the elements you need to print.
    •	Loop through the result list and take only the elements that fulfill the condition.
    •	Print the elements ordered in ascending order and separated by a space.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> listA = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> mixedList = new ArrayList<>();

        int iterations = Math.min(listA.size(), listB.size());

        for (int currentIteration = 1; currentIteration <= iterations; currentIteration++) {
            mixedList.add(listA.get(0));
            listA.remove(0);
            mixedList.add(listB.get(listB.size() - 1));
            listB.remove(listB.size() - 1);
        }

        int lowerRange;
        int higherRange;
        if (listA.isEmpty()) {
            lowerRange = Math.min(listB.get(0), listB.get(1));
            higherRange = Math.max(listB.get(0), listB.get(1));
        } else {
            lowerRange = Math.min(listA.get(0), listA.get(1));
            higherRange = Math.max(listA.get(0), listA.get(1));
        }
        List<Integer> sortedList = new ArrayList<>();

        while (!mixedList.isEmpty()) {
            if (mixedList.get(0) > lowerRange && mixedList.get(0) < higherRange) {
                sortedList.add(mixedList.get(0));
                mixedList.remove(0);
            } else {
                mixedList.remove(0);
            }
        }
        Collections.sort(sortedList);
        System.out.println(sortedList.toString().replaceAll("[\\[\\],]", ""));
    }
}