package I_UnitTesting.L03_Mocking.interfaces;

public interface Target {

    void takeAttack(int attackPoints);
    int getHealth();
    int giveExperience();
    boolean isDead();
    Weapon dropRandomWeapon();
}
