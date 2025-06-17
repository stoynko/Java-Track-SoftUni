package A_WorkingWithAbstraction.E05_JediGalaxy.Methods_Refactoring;

import java.util.*;

public class E05_JediGalaxy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = fillMatrix(scanner);
        String command = scanner.nextLine();
        long collectedStars = 0;

        while (!command.equals("Let the Force be with you")) {

            int[] playerPos = readPosition(command);
            int[] enemyPos = readPosition(scanner.nextLine());
            moveEnemy(matrix, enemyPos);
            collectedStars += movePlayer(matrix, playerPos);

            command = scanner.nextLine();
        }

        System.out.println(collectedStars);


    }

    private static void moveEnemy(int[][] matrix, int[] enemyPos) {
        int enemyX = enemyPos[0];
        int enemyY = enemyPos[1];

        while (enemyX >= 0 && enemyY >= 0) {
            if (isWithinMatrix(matrix, enemyX, enemyY)) {
                matrix[enemyX][enemyY] = 0;
            }
            enemyX--;
            enemyY--;
        }
    }

    private static long movePlayer (int[][] matrix, int[] playerPos) {
        int playerX = playerPos[0];
        int playerY = playerPos[1];
        long collectedStars = 0;

        while (playerX >= 0 && playerY < matrix[0].length) {
            if (isWithinMatrix(matrix, playerX, playerY)) {
                collectedStars += matrix[playerX][playerY];
            }

            playerY++;
            playerX--;
        }
        return collectedStars;
    }

    private static boolean isWithinMatrix(int[][] matrix, int posX, int posY) {
        return posX >= 0 && posX < matrix.length && posY >= 0 && posY < matrix[0].length;
    }

    private static int[] readPosition(String input) {
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] fillMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];
        int[][] matrix = new int[rows][columns];

        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = value++;
            }
        }
        return matrix;
    }
}

