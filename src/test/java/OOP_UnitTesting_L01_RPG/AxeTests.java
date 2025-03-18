package OOP_UnitTesting_L01_RPG;

import D_OOP.I_UnitTesting.L01_RPG.*;
import org.junit.jupiter.api.*;

public class AxeTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 1;

    private Axe axe;
    private Dummy dummy;

    @BeforeEach
    public void init() {
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void WhenAxeIsUsedForAttacks_ThenLosesDurability() {
        axe.attack(dummy);
        Assertions.assertEquals(0, axe.getDurabilityPoints());
    }
    @Test
    public void WhenAxeHasNoDurabilityAndIsUsed_thenIllegalArgumentExceptionIsThrown() {
        axe = new Axe(AXE_ATTACK, 0);
        Assertions.assertThrows(IllegalStateException.class, () -> axe.attack(new Dummy(5, 5)));
    }
}
