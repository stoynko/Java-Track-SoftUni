package OOP.I_UnitTesting.L02_LuckyWheel;

import D_OOP.I_UnitTesting.L02_LuckyWheel.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.*;

public class LuckyWheelTests {

    // If we risk 5USD and the random number is 100, the expected result is 500

    @Test
    public void whenRisking5USDAndRandomNumberIs100_thenResultIs500() {

        Random random = Mockito.mock(Random.class);
        Mockito.when(random.nextInt()).thenReturn(100);
        LuckyWheel luckyWheel = new LuckyWheel(random);

        int result = luckyWheel.riskToWin(5);

        Assertions.assertEquals(500, result);
    }

    // If we risk 5USD and the random number is 2, the expected result is 10

    @Test
    public void whenRisking5USDAndRandomNumberIs2_thenResultIs10() {

        Random random = Mockito.mock(Random.class);
        Mockito.when(random.nextInt()).thenReturn(2);
        LuckyWheel luckyWheel = new LuckyWheel(random);

        int result = luckyWheel.riskToWin(5);

        Assertions.assertEquals(10, result);
    }

    // If we risk 5USD and the random number neiter 100 or 2, the risked amount is reduced to 4

    @Test
    public void whenRisking5USDAndRandomNumberIsNot2Or100_thenRiskedAmountIsReducedTo4() {

        Random random = Mockito.mock(Random.class);
        Mockito.when(random.nextInt()).thenReturn(10);
        LuckyWheel luckyWheel = new LuckyWheel(random);
        int result = luckyWheel.riskToWin(5);

        Assertions.assertEquals(4, result);
    }
}
