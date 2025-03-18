package L01_RPG;

import D_OOP.I_UnitTesting.L01_RPG.*;
import org.junit.jupiter.api.*;

public class AxeTests {

    @Test
    public void whenAxeHasTenPointsDurabilityAndAttacksTarget_ThenDurabilityPointsDecreaseToNine() {

        Axe axe = new Axe(2, 10);
        axe.attack(new Dummy(5, 5));
        Assertions.assertEquals(9, axe.getDurabilityPoints());
    }
    @Test
    public void whenAxeHasNoDurabilityAndAttacksTarget_ThenExpectIllegalArgumentException() {

        Axe axe = new Axe(2, 0);

        Assertions.assertThrows(IllegalStateException.class, () -> {
            axe.attack(new Dummy(5, 5));
        });
    }

}
