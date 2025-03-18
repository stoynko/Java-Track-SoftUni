package D_OOP.I_UnitTesting.L03_Mocking;

import D_OOP.I_UnitTesting.L03_Mocking.interfaces.*;

import java.util.*;

public class Dummy implements Target {

    private int health;
    private int experience;
    private List<Weapon> possibleLoot;

    public Dummy (int health, int experience) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = new ArrayList<>();
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    @Override
    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    @Override
    public boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public Weapon dropRandomWeapon() {
       Random random = new Random();
       int randomItemIndex = random.nextInt(possibleLoot.size() - 1 );
       Weapon weaponToDrop = possibleLoot.get(randomItemIndex);
       possibleLoot.remove(randomItemIndex);
       return weaponToDrop;
    }
}
