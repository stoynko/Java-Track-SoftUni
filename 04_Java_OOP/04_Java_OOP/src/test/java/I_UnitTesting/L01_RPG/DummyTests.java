package I_UnitTesting.L01_RPG;

import org.junit.jupiter.api.*;

public class DummyTests {

/*Create a class DummyTest.
Create the following tests:
    •	Dummy loses health if attacked.
    •	Dead Dummy throws an exception if attacked.
    •	Dead Dummy can give XP.
    •	Alive Dummy can't give XP. */

    private final static int DUMMY_ALIVE_HEALTH = 100;
    private static final int DUMMY_DEAD_HEALTH = 0;
    private static final int DUMMY_EXPERIENCE = 1;
    private static final int ATTACK_POINTS = 1;

    private Dummy dummyAlive;
    private Dummy dummyDead;

    @BeforeEach
    public void init() {
        dummyAlive = new Dummy(DUMMY_ALIVE_HEALTH, DUMMY_EXPERIENCE);
        dummyDead = new Dummy(DUMMY_DEAD_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void WhenDummyIsAttacked_DummyLosesHealth(){
       dummyAlive.takeAttack(ATTACK_POINTS);
       Assertions.assertEquals(DUMMY_ALIVE_HEALTH - ATTACK_POINTS, dummyAlive.getHealth());
    }

    @Test
    public void WhenDeadDummyIsAttached_ThenThrowsIllegalStateException() {
        Assertions.assertThrows(IllegalStateException.class, () -> dummyDead.takeAttack(ATTACK_POINTS));
    }

    @Test
    public void WhenDummyIsDead_GivesExperience() {
        int xp = dummyDead.giveExperience();
        Assertions.assertEquals(DUMMY_EXPERIENCE, xp);
    }

    @Test
    public void WhenDummyIsAlive_DoesNotGiveExperience() {
        Assertions.assertThrows(IllegalStateException.class, () -> dummyAlive.giveExperience());
    }
}
