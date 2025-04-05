package D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magicians;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.common.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magics.*;

public class MagicianImpl implements Magician {

    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        this.isAlive = true;
        setMagic(magic);
    }

    public void setUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    public void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    public void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_NAME);
        }
        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void takeDamage(int points) {

        if (this.protection == 0){
            this.health -= points;
        } else if (this.protection - points < 0) {
            int additionalDamage = Math.abs(this.protection - points);
            this.protection = 0;
            this.health -= additionalDamage;
            if (this.health <= 0) {
                this.isAlive = false;
            }
        } else {
            this.protection -= points;
        }

    }
}
