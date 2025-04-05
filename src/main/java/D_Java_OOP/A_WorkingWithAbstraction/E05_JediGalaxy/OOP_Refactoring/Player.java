package D_Java_OOP.A_WorkingWithAbstraction.E05_JediGalaxy.OOP_Refactoring;

public class Player {

    public long movePlayer(int playerX, int playerY, Field field) {
        long starsCollected = 0;

        while (playerX >= 0 && playerY < field.getFieldLength()) {
            if (field.isWithinField(playerX, playerY)) {
                starsCollected += field.getValue(playerX, playerY);
            }
            playerY++;
            playerX--;
        }
        return starsCollected;
    }
}
