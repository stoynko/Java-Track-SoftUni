package D_ForLoop;

import java.util.*;

public class E08_TennisRanklist {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int tournamentsParticipated = Integer.parseInt(scanner.nextLine());
        int pointsRanklist = Integer.parseInt(scanner.nextLine());
        int pointsWon = 0;
        int tournamentsWon = 0;

        for (int i = 0; i < tournamentsParticipated; i++) {

            String tournamentResult = scanner.nextLine();
            if (tournamentResult.equals("W")) {
                tournamentsWon++;
                pointsWon += 2000;
            } else if (tournamentResult.equals("F")) {
                pointsWon += 1200;
            } else if (tournamentResult.equals("SF")) {
                pointsWon += 720;
            }
        }

        int pointsTotal = pointsRanklist + pointsWon;
        double pointsAverage = (double) pointsWon / tournamentsParticipated;
        double tournamentsPercentageWon = (double) tournamentsWon / tournamentsParticipated * 100;

        System.out.printf("Final points: %d\n", pointsTotal);
        System.out.printf("Average points: %.0f\n", Math.floor(pointsAverage));
        System.out.printf("%.2f%%\n", tournamentsPercentageWon);
    }
}