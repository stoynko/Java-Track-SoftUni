package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class L06_MaxNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int maxNum = Integer.MIN_VALUE;

        while (!input.equals("Stop")) {
            int numInput = Integer.parseInt(input);
            if (numInput > maxNum) {
                maxNum = numInput;
            }
            input = scanner.nextLine();
        }
        System.out.println(maxNum);
    }
}
