package D_Java_OOP.I_UnitTesting.L02_LuckyWheel;

import java.util.*;

public class LuckyWheel {

    private Random randomNumber;

    public LuckyWheel(Random random) {
        this.randomNumber = random;
    }

    public int riskToWin(int amount) {
        int luckyNumber = randomNumber.nextInt();

        if (luckyNumber == 100 ) {
            return amount * 100;
        } else if (luckyNumber == 2) {
            return amount * 2;
        } else {
            return amount - 1;
        }
    }
}
