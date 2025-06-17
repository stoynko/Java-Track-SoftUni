package D_ForLoop;

import java.util.*;

public class E06_Oscars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double result = Double.parseDouble(scanner.nextLine());
        int judgeCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= judgeCount; i++) {
            String judgeName = scanner.nextLine();
            double judgePoints = Double.parseDouble(scanner.nextLine());
            result += (judgeName.length() * judgePoints) / 2;

            if (result >= 1250.5)
                break;
        }

        if (result > 1250.5) {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, result);
        } else
            System.out.printf("Sorry, %s you need %.1f more!", actorName, 1250.5 - result);
    }
}
