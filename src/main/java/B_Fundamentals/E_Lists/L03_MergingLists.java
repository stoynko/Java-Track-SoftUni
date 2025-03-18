package B_Fundamentals.E_Lists;

import java.util.*;
import java.util.stream.*;

public class L03_MergingLists {

/*You are going to receive two lists with numbers. Create a result list that contains the numbers from both of the lists.
The first element should be from the first list, the second from the second list, and so on.
If the length of the two lists is not equal, just add the remaining elements at the end of the list.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> ListA = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> ListB = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> mergedList = new ArrayList<>();

        int cycleCount = Math.min(ListA.size(), ListB.size());

        if (ListA.size() > ListB.size()) {
            int index = 0;
            while (index < cycleCount) {
                mergedList.add(ListA.get(index));
                mergedList.add(ListB.get(index));
                index++;
            }
            while (index < ListA.size()) {
                mergedList.add(ListA.get(index));
                index++;
            }
        } else {
            int index = 0;
            while (index < cycleCount) {
                mergedList.add(ListA.get(index));
                mergedList.add(ListB.get(index));
                index++;
            }
            while (index < ListB.size()) {
                mergedList.add(ListB.get(index));
                index++;
            }
        }

        for (int number : mergedList) {
            System.out.printf("%d ", number);
        }
    }
}