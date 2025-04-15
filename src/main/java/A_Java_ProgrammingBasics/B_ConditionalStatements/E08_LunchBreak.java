package A_Java_ProgrammingBasics.B_ConditionalStatements;

import java.util.*;

public class E08_LunchBreak {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int movieDuration = Integer.parseInt(scanner.nextLine());
        int breakDuration = Integer.parseInt(scanner.nextLine());

        double lunchDuration = 0.125 * breakDuration;
        double restDuration = 0.25 * breakDuration;
        double spentTime = lunchDuration + restDuration;
        double freeTime = breakDuration - spentTime;

        if (freeTime >= movieDuration) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", name, Math.ceil(breakDuration - (movieDuration + spentTime)));
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", name, Math.ceil(movieDuration - freeTime));
        }
    }
}
