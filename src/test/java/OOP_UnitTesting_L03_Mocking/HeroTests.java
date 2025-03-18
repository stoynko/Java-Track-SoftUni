package OOP_UnitTesting_L03_Mocking;

import D_OOP.I_UnitTesting.L01_RPG.*;
import D_OOP.I_UnitTesting.L01_RPG.interfaces.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

public class HeroTests {

/*Test if the hero gains XP when a target dies. To do this, you need to:
    •	Make Hero class testable (use Dependency Injection).
    •	Introduce Interfaces for Axe and Dummy:
        o	Interface Weapon
        o	Interface Target

Create a fake Weapon and fake Dummy for the test. */

    private Target fakeTarget;
    private Weapon fakeWeapon;

    @Test
    public void attackerGainsExperienceIfTargetDies() {

        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(10);

        Hero hero = new Hero("Roger", weaponMock);
        hero.attack(targetMock);
        Assertions.assertEquals(10, hero.getExperience(), "Wrong experience");
    }

    @Test
    public void attackedReceivesRandomlyDroppedWeaponIfTargetDies() {

    }
}
