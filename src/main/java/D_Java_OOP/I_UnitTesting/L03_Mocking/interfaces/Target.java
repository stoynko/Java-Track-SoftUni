package D_Java_OOP.I_UnitTesting.L03_Mocking.interfaces;

public interface Target {

    void takeAttack(int attackPoints);
    int getHealth();
    int giveExperience();
    boolean isDead();
    Weapon dropRandomWeapon();
}
