package D_Java_OOP.A_WorkingWithAbstraction.E05_JediGalaxy.OOP_Refactoring;

public class Enemy {

    public void moveEnemy(int enemyX, int enemyY, Field field) {
        while (enemyX >= 0 && enemyY >= 0) {
            if (field.isWithinField(enemyX, enemyY)) {
                field.setValue(enemyX, enemyY, 0);
            }
            enemyX--;
            enemyY--;
        }
    }
}
