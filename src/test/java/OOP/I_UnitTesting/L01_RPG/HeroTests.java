package OOP.I_UnitTesting.L01_RPG;

import D_OOP.I_UnitTesting.L01_RPG.*;
import D_OOP.I_UnitTesting.L01_RPG.interfaces.*;
import org.junit.jupiter.api.*;

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

        fakeTarget = new Target() {

            @Override
            public void takeAttack(int attackPoints) {}

            @Override
            public int getHealth() {return 0;}

            @Override
            public int giveExperience() {return 10;}

            @Override
            public boolean isDead() {return true;}
        };

        fakeWeapon = new Weapon() {

            @Override
            public void attack(Target target) {}

            @Override
            public int getAttackPoints() {return 10;}

            @Override
            public int getDurabilityPoints() {return 10;}
        };

        Hero hero = new Hero("Roger", fakeWeapon);
        hero.attack(fakeTarget);
        Assertions.assertEquals(10, hero.getExperience(), "Wrong experience");
    }
}
