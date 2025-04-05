package D_Java_OOP.I_UnitTesting.L03_Mocking;

import D_Java_OOP.I_UnitTesting.L03_Mocking.interfaces.*;

import java.util.*;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> inventory;

    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            this.inventory.add(target.dropRandomWeapon());
        }
    }

    public Iterable<Weapon> getInventory() {
        return this.inventory;
    }
}
