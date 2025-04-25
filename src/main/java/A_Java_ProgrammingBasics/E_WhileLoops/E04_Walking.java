package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class E04_Walking {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int goal = 10000;
        String input = scanner.nextLine();
        int steps = 0;
        int stepsCount = 0;

        while (true) {
            if (input.equals("Going home")) {
                steps = Integer.parseInt(scanner.nextLine());
                stepsCount += steps;
                if (stepsCount < goal) {
                    System.out.printf("%d more steps to reach goal.\n", goal - stepsCount);
                    break;
                } else {
                    System.out.println("Goal reached! Good job!");
                    System.out.printf("%d steps over the goal!\n", stepsCount - goal);
                    break;
                }
            }

            steps = Integer.parseInt(input);
            stepsCount += steps;

            if (stepsCount >= goal) {
                System.out.println("Goal reached! Good job!");
                System.out.printf("%d steps over the goal!\n", stepsCount - goal);
                break;
            }
            input = scanner.nextLine();
        }
    }
}