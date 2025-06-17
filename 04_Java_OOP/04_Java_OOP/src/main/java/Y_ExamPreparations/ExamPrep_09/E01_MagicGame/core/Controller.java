package Y_ExamPreparations.ExamPrep_09.E01_MagicGame.core;

public interface Controller {
    String addMagic(String type, String name, int bulletsCount);
    String addMagician(String type, String username, int health, int protection, String magicName);
    String startGame();
    String report();
}

