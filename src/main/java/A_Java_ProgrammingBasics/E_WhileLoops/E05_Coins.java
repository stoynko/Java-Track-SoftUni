package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class E05_Coins {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());
        int changeRounded = (int) Math.round(change * 100);
        int coinCounter = 0;

        while (changeRounded > 0) {
            if (changeRounded >= 200) {
                changeRounded -= 200;
                coinCounter++;
            } else if (changeRounded >= 100) {
                changeRounded -= 100;
                coinCounter++;
            } else if (changeRounded >= 50) {
                changeRounded -= 50;
                coinCounter++;
            } else if (changeRounded >= 20) {
                changeRounded -= 20;
                coinCounter++;
            } else if (changeRounded >= 10) {
                changeRounded -= 10;
                coinCounter++;
            } else if (changeRounded >= 5) {
                changeRounded -= 5;
                coinCounter++;
            } else if (changeRounded >= 2) {
                changeRounded -= 2;
                coinCounter++;
            } else if (changeRounded >= 1) {
                changeRounded -= 1;
                coinCounter++;
            }
        }
        System.out.println(coinCounter);
    }
}
