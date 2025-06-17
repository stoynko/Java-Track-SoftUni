package B_ConditionalStatements;

import java.util.*;

public class E06_WorldSwimmingRecord {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double recordTime = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timePerMeter = Double.parseDouble(scanner.nextLine());
        boolean newRecord = false;

        double time = distance * timePerMeter;
        double timePenalty = Math.floor(distance / 15) * 12.5;

        double newTime = time + timePenalty;
        newRecord = newTime < recordTime;

        if (newRecord) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", newTime);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", newTime - recordTime);
        }
    }
}
