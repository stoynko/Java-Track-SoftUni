package A_Java_ProgrammingBasics.F_NestedLoops;

import java.util.*;

public class L06_Building {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int floors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());
        String prefix = "";
        for (int floor = floors; floor >= 1; floor--) {
            for (int room = 0; room < rooms; room++) {
                if (floor == floors)
                    prefix = "L";
                else if (floor % 2 == 0)
                    prefix = "O";
                else
                    prefix = "A";
                System.out.printf("%s%d%d ", prefix, floor, room);
            }
            System.out.println();
        }
    }
}