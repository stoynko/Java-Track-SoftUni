package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class E06_Cake {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cakeWidth = Integer.parseInt(scanner.nextLine());
        int cakeLength = Integer.parseInt(scanner.nextLine());
        int cakeTotal = cakeLength * cakeWidth;

        String input = scanner.nextLine();

        while (true) {
            if (input.equals("STOP")) {
                System.out.printf("%d pieces are left.", cakeTotal);
                break;
            }
            int cakePieces = Integer.parseInt(input);
            cakeTotal -= cakePieces;
            if (cakeTotal <= 0) {
                System.out.printf("No more cake left! You need %d pieces more.", Math.abs(cakeTotal));
                break;
            }
            input = scanner.nextLine();
        }
    }
}