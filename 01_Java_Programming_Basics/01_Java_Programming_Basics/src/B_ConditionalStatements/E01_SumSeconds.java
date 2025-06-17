package B_ConditionalStatements;

import java.util.*;

public class E01_SumSeconds {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int time01 = Integer.parseInt(scanner.nextLine());
        int time02 = Integer.parseInt(scanner.nextLine());
        int time03 = Integer.parseInt(scanner.nextLine());

        int timeSum = time01 + time02 + time03;
        int minutes = timeSum / 60;
        int seconds = timeSum % 60;

        if (seconds < 10) {
            System.out.printf("%d:0%d", minutes, seconds);
        } else {
            System.out.printf("%d:%d", minutes, seconds);
        }
    }
}