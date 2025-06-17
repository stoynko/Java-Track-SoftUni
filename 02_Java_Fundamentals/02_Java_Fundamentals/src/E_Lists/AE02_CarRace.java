package E_Lists;

import java.util.*;
import java.util.stream.*;

public class AE02_CarRace {

/*Write a program to calculate the winner of a car race. You will receive an array of numbers.
Each array element represents the time needed to pass through that step (the index). There are going to be two cars.
One of them starts from the left side, and the other one starts from the right side.
The middle index of the array is the finish line. (The number of elements of the array will always be odd).
Calculate the total time for each racer to reach the finish (the middle of the array) and print the winner with his total time. (The racer with less time).
If you have a zero in the array, you must reduce the racer's time that reached it by 20% (from the time so far).

Print the result in the following format "The winner is {left/right} with total time: {total time}", formatted with one digit after the decimal point.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> raceTimes = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int indexFinishLine = raceTimes.size() / 2;
        List<Integer> driverA = raceTimes.subList(0, indexFinishLine);
        List<Integer> driverB = raceTimes.subList(indexFinishLine + 1, raceTimes.size());
        Collections.reverse(driverB);
        String winner = "";
        double sumA = calculateDriverResult(driverA);
        double sumB = calculateDriverResult(driverB);
        double bestTime = Math.min(sumA, sumB);

        if (bestTime == sumA) {
            winner = "left";
            bestTime = sumA;
        } else {
            winner = "right";
            bestTime = sumB;
        }

        System.out.printf("The winner is %s with total time: %.1f", winner, bestTime);
    }

    private static double calculateDriverResult(List<Integer> list) {
        double sum = 0;
        for (int element : list) {
            if (element == 0) {
                sum *= 0.8;
            } else {
                sum += element;
            }
        }
        return sum;
    }
}