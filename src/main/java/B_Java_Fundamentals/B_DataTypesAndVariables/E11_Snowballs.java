package B_Java_Fundamentals.B_DataTypesAndVariables;

import java.util.*;

public class E11_Snowballs {

/*Tony and Andi love playing in the snow and having snowball fights, but they always argue about which makes the best snowballs.
They have decided to involve you in their fray by making you write a program that calculates snowball data and outputs the best snowball value.
You will receive N – an integer, the number of snowballs being made by Tony and Andi. For each snowball, you will receive 3 input lines:
    •	On the first line, you will get the snowballSnow – an integer.
    •	On the second line, you will get the snowballTime – an integer.
    •	On the third line, you will get the snowballQuality – an integer.

For each snowball, you must calculate its snowballValue by the following formula: (snowballSnow / snowballTime) ^ snowballQuality

In the end, you must print the highest calculated snowballValue.

Input:
    •	On the first input line, you will receive N – the number of snowballs.
    •	On the next N * 3 input lines, you will receive data about snowballs.
Output:
    •	As output, you must print the highest calculated snowballValue, by the formula specified above.
    •	The output format is: "{snowballSnow} : {snowballTime} = {snowballValue} ({snowballQuality})"
Constraints:
    •	The number of snowballs (N) will be an integer in the range [0, 100].
    •	The snowballSnow is an integer in the range [0, 1000].
    •	The snowballTime is an integer in the range [1, 500].
    •	The snowballQuality is an integer in the range [0, 100].
    •	Allowed working time / memory: 100ms / 16MB.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte snowballs = Byte.parseByte(scanner.nextLine());

        int bestSnow = 0;
        int bestTime = 0;
        int bestQuality = 0;
        long bestValue = 0;

        for (int i = 1; i <= snowballs; i++) {

            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            long snowballValue = (long) Math.pow(((double) snowballSnow / snowballTime),
                    snowballQuality);

            if (snowballValue > bestValue) {
                bestSnow = snowballSnow;
                bestTime = snowballTime;
                bestQuality = snowballQuality;
                bestValue = snowballValue;
            }
        }
        System.out.printf("%d : %d = %d (%d)",
                bestSnow, bestTime, bestValue, bestQuality);
    }
}