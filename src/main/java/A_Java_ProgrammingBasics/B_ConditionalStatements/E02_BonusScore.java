package A_Java_ProgrammingBasics.B_ConditionalStatements;

import java.util.*;

public class E02_BonusScore {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int points = Integer.parseInt(scanner.nextLine());
        double bonusPoints = 0;

        if (points <= 100) {
            bonusPoints = 5;
            if (points % 2 == 0)
                bonusPoints++;
            else if (points % 10 == 5)
                bonusPoints = bonusPoints + 2;
        } else if (points > 1000) {
            bonusPoints = points * 0.1;
            if (points % 2 == 0)
                bonusPoints++;
            else if (points % 10 == 5)
                bonusPoints = bonusPoints + 2;
        } else {
            bonusPoints = points * 0.2;
            if (points % 2 == 0)
                bonusPoints++;
            else if (points % 10 == 5)
                bonusPoints = bonusPoints + 2;
        }

        System.out.println(bonusPoints);
        System.out.println(points + bonusPoints);
    }
}