package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class L07_MinNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int minNum = Integer.MAX_VALUE;

        while (!input.equals("Stop")) {
            int numInput = Integer.parseInt(input);
            if (numInput < minNum) {
                minNum = numInput;
            }
            input = scanner.nextLine();
        }
        System.out.println(minNum);
    }
}