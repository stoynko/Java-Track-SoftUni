package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class L01_ReadText {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            System.out.println(input);
            input = scanner.nextLine();
        }
    }
}