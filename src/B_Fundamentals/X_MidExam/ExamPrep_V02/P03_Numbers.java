package B_Fundamentals.X_MidExam.ExamPrep_V02;

import java.util.*;
import java.util.stream.*;

public class P03_Numbers {

/*Write a program to read a sequence of integers and find and print the top 5 numbers greater than the average value in the sequence, sorted in descending order.

Input
    • Read from the console a single line holding space-separated integers.
Output
    • Print the above-described numbers on a single line, space-separated.
    • If less than 5 numbers hold the property mentioned above, print less than 5 numbers.
    • Print "No" if no numbers hold the above property.
Constraints
    • All input numbers are integers in the range [-1 000 000 … 1 000 000].
    • The count of numbers is in the range [1…10 000].*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listOfTopElements = new ArrayList<>();
        double sumofElements = getSumofElements(list);
        double averageElementValue = sumofElements / list.size();
        findTopNumbers(list, listOfTopElements, averageElementValue);
        if (listOfTopElements.isEmpty()) {
            System.out.println("No");
        }
    }

    private static void findTopNumbers(List<Integer> list, List<Integer> listOfTopElements, double averageElementValue) {
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) > averageElementValue) {
                listOfTopElements.add(list.get(index));
            }
        }
        Collections.sort(listOfTopElements, Collections.reverseOrder());
        if (listOfTopElements.size() > 5) {
            listOfTopElements = listOfTopElements.subList(0, 5);
        }
        System.out.println(listOfTopElements.toString().replaceAll("[\\[\\],]", ""));
    }

    private static int getSumofElements(List<Integer> list) {
        int sumOfElements = 0;
        for (int index = 0; index < list.size(); index++) {
            sumOfElements += list.get(index);
        }
        return sumOfElements;
    }
}