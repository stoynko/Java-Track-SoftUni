package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class E07_Moving {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int freeSpaceWidth = Integer.parseInt(scanner.nextLine());
        int freeSpaceLength = Integer.parseInt(scanner.nextLine());
        int freeSpaceHeight = Integer.parseInt(scanner.nextLine());
        int freeSpaceTotal = freeSpaceWidth * freeSpaceLength * freeSpaceHeight;
        String input = scanner.nextLine();

        while (true) {
            if (input.equals("Done") && freeSpaceTotal > 0) {
                System.out.printf("%d Cubic meters left.\n", freeSpaceTotal);
                break;
            }
            int boxes = Integer.parseInt(input);
            freeSpaceTotal -= boxes;

            if (freeSpaceTotal < 0) {
                System.out.printf("No more free space! You need %d Cubic meters more.\n", Math.abs(freeSpaceTotal));
                break;
            }
            input = scanner.nextLine();
        }
    }
}