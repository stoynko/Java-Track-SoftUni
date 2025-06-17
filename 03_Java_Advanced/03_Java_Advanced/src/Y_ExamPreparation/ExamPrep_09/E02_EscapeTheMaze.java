package Y_ExamPreparation.ExamPrep_09;

import java.util.*;

public class E02_EscapeTheMaze {

/*You are a brave traveler that got lost in a maze and you need to find your way out. The maze is represented by a matrix - field.
Each cell in the field represents a part of the maze, and it can contain one of the following elements:
    •	'P' - Represents the starting position of the traveller.
    •	'X' - Represents the location of the exit that leads outside of the maze.
    •	'M' - Represents a monster which wants to harm the traveller.
    •	'H' - Represents a health potion which will restore the health of the traveller.
    •	'-' – Represents the maze's corridors, which the traveller can walk through.

Initially, you will be given N – an integer, indicating the size of a square matrix. The traveller starts with 100 units of health.
The traveller must carefully navigate through the maze, following the commands that will be received on each of the following lines-
"up", "down", "right", and "left", moving one position towards the direction given.
If the command leads the traveller outside the bounds of the field, skip the command and proceed with the next one.
However, in the maze, encountering a cell marked with 'M' signifies the presence of a monster. When the traveller encounters a monster,
he takes substantial damage, his health is reduced by 40 units. It's important to note that the monster disappears from the maze only
if the traveller survives the encounter. In the case where the traveller's health drops to 0 or below due to the encounter with a monster,
the traveller is considered defeated, health is set to zero and the maze traversal concludes. If the traveller survives,
the monster disappears from the maze, and its position is marked with '-'.
This indicates that the monster has been successfully dealt with and is no longer a threat in the subsequent maze traversal.
In addition, within the maze, encountering a cell marked with 'H' signifies the presence of a health potion.
When the traveller encounters a health potion, he moves in that direction and experiences a boost in his health by 15 units.
It's crucial to note that the traveller's health may happen to exceed the maximum limit of 100 units during the adventure.
If the traveller's health surpasses 100 units due to the health potion, it is adjusted to the maximum limit of 100 units.
This ensures that the traveller's health does not exceed the predefined maximum value. The position is marked with '-'.
Once the traveller successfully reaches a position marked as 'X', he finally reaches the exit and escapes the maze. The adventure is over.
Remember, the traveller must follow the commands, he will always either reach the exit or die in the maze.
In the end, print the final state of the matrix (maze area) with the traveller in his ending position. Each row is on a new line.

Input:
    •	On the first line, you will get N -the size of the matrix (square).
    •	On the next N lines, you will receive strings, representing each row of the matrix.
    •	On each of the following lines, you will receive the possible directions for the traveller to move - "up", "down", "right", and "left".
Output:
    •	On the first line:
        o	If the traveller has less than or equal to 0 health: "Player is dead. Maze over!"
        o	If the traveller survived with more than 0 health and managed to escape the maze: "Player escaped the maze. Danger passed!"
    •	On the second line, print the final value of the traveller's health following the format: "Player's health: {health value} units"
    •	On the next lines, print the final state of the matrix with the traveller in its ending position. Each row - on a new line.

Constraints:
    •	The commands are guaranteed to lead him either to escape out of the maze or to die by monsters, ensuring that the commands are sufficient in all cases.
    •	Some commands may lead our hero outside of the boundaries of the matrix. Do not allow that.
    •	The size of the matrix will always be a valid positive integer in the range [4,10].
    •	The last known position of the traveller should always be marked with 'P' in the final state of the matrix. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] playerPos = new int[2];
        int[] exitPos = new int[2];
        char[][] maze = fillMatrix(scanner, playerPos, exitPos);
        int[] playerOldPos = Arrays.copyOfRange(playerPos, 0, playerPos.length);
        int playerHP = 100;

        while (playerHP > 0 && !Arrays.equals(playerPos, exitPos)) {

            String command = scanner.nextLine();
            playerOldPos = Arrays.copyOfRange(playerPos, 0, playerPos.length);
            switch (command) {
                case "up" -> playerPos[0] -= 1;
                case "down" -> playerPos[0] += 1;
                case "left" -> playerPos[1] -= 1;
                case "right" -> playerPos[1] += 1;
            }

            if (isWithin(playerPos, maze.length)) {
                if (maze[playerPos[0]][playerPos[1]] == '-') {
                    maze[playerPos[0]][playerPos[1]] = 'P';
                    maze[playerOldPos[0]][playerOldPos[1]] = '-';
                } else if (maze[playerPos[0]][playerPos[1]] == 'M') {
                    playerHP -= 40;
                    if (playerHP > 0) {
                        maze[playerPos[0]][playerPos[1]] = 'P';
                    }
                    maze[playerOldPos[0]][playerOldPos[1]] = '-';
                } else if (maze[playerPos[0]][playerPos[1]] == 'H') {
                    playerHP += 15;
                    if (playerHP > 100) {
                        playerHP = 100;
                    }
                    maze[playerPos[0]][playerPos[1]] = 'P';
                    maze[playerOldPos[0]][playerOldPos[1]] = '-';
                } else {
                    maze[playerOldPos[0]][playerOldPos[1]] = '-';
                }
            } else {
                playerPos = Arrays.copyOfRange(playerOldPos, 0, playerPos.length);
            }
        }

        System.out.println(playerHP > 0 ? "Player escaped the maze. Danger passed!" : "Player is dead. Maze over!");
        System.out.println(playerHP > 0 ? String.format("Player's health: %d units", playerHP) : "Player's health: 0 units");
        print(maze, playerPos);
    }

    private static boolean isWithin(int[] playerPos, int fieldSize) {
        return playerPos[0] >= 0 && playerPos[0] < fieldSize && playerPos[1] >= 0 && playerPos[1] < fieldSize;
    }

    public static char[][] fillMatrix(Scanner scanner, int[] playerPos, int[] exitPos) {

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            String rowData = scanner.nextLine().replace(" ", "");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = rowData.charAt(col);
                if (rowData.charAt(col) == 'P') {
                    playerPos[0] = row;
                    playerPos[1] = col;
                }
                if (rowData.charAt(col) == 'X') {
                    exitPos[0] = row;
                    exitPos[1] = col;
                }
            }
        }
        return matrix;
    }

    private static void print(char[][] matrix, int[] playerPos) {
        matrix[playerPos[0]][playerPos[1]] = 'P';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}