package A_WorkingWithAbstraction.E05_JediGalaxy.OOP_Refactoring;

public class Galaxy {

    Player player = new Player();
    Enemy enemy = new Enemy();
    private Field field;

    public Galaxy(Field field) {
        this.field = field;
        this.player = new Player();
        this.enemy = new Enemy();
    }

    public long movePlayer(int[] playerPosition) {
        int playerX = playerPosition[0];
        int playerY = playerPosition[1];
        return player.movePlayer(playerX, playerY, field);
    }


    public void moveEnemy(int [] enemyPos) {
        int enemyX = enemyPos[0];
        int enemyY = enemyPos[1];
        enemy.moveEnemy(enemyX, enemyY, field);
    }
}
