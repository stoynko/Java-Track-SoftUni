package D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magicians;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_09.E01_MagicGame.models.magics.Magic;

public interface Magician {
    String getUsername();
    int getHealth();
    int getProtection();
    Magic getMagic();
    boolean isAlive();
    void takeDamage(int points);
}
