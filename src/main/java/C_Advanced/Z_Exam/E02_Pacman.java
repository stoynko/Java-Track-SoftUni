package C_Advanced.Z_Exam;

import java.util.*;

public class E02_Pacman {

/*You will be given an integer N for the size of the square game field (grid). On the next lines, you will receive the rows of the field.
The Pacman is marked with the letter 'P' and starts at a random position on the grid. The goal is to guide Pacman in collecting all the stars while avoiding health loss caused by ghosts.
Star positions are marked with the symbol '*' while the ghost positions are marked with 'G'. Pacman initially starts with 100 units of health.
Pacman continues to receive movement commands until the special "END" command is issued, signalling the termination of input. During this time,
Pacman can navigate freely across the grid in any of the four directions: up, down, left, or right.
    •	When Pacman makes the first move, mark its starting position as empty with a dash '-'.
    •	If Pacman reaches an empty position ('-' dash), it waits for the next direction.
    •	Pacman collects a star '*' when moving onto a star cell. The star is removed from the grid, and the total count of remaining stars is decreased by 1. The cell must be marked as empty with a dash  '-'.
        Hint: Consider determining the total count of stars placed initially on the grid.
    •	Moving onto a ghost position ('G') reduces Pacman's health by 50 units. The cell must be marked as empty with a dash '-'.
        o	If Pacman hits two ghosts, his health reaches zero 0, and the game ends.
    •	Moving onto a freezer 'F' freezes Pacman temporarily and gives him immunity against the next encountered ghost (the ghost will take no damage but just for once).
        The position must be marked with a dash '-'.
    •	A movement outside (leaving the grid's boundaries) positions Pacman to the opposite side.
        Example: Moving out of the top boundary repositions Pacman at the bottom of the same column.
The program ends in one of the following cases:
    •	Pacman collects all the stars placed initially on the field.
    •	Pacman's health reaches zero 0.
    •	Command "END" is received and Pacman is forced to stop moving.

Input:
    •	An integer N representing the square grid (field) size.
    •	The next N lines hold the values for every row.
    •	Following are direction commands, each on a new line.

Output:
    •	If Pacman's health reaches zero 0, print: "Game over! Pacman last coordinates [{row},{col}]"
    •	If Pacman manages to collect all the stars, print: "Pacman wins! All the stars are collected."
    •	If Pacman's health is more than zero 0 but it did not collect all the stars and there are no more commands for movements,
        print: "Pacman failed to collect all the stars."
    •	Following print:
        o	In all cases: "Health: {remaining_health}"
        o	If there are still stars to collect, print (otherwise skip it):
            "Uncollected stars: {uncollected_stars_count}"
    •	Finally print the final state of the grid (field) with the last known position of Pacman on it marked with 'P'.

Constraints:
    •	The square grid (field) size will be between [3…8] inclusive.
    •	Commands will always be valid (up, down, left, right).
    •	Pacman will always have a valid starting position 'P'.
    •	Stars marked by '*' will always be present on the field.
    •	Ghosts 'G' will always be at least two.
    •	Freezers 'F' can be zero or one.
    •	Empty cells marked with a dash '-'. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] initialData = new int[3];
        char[][] gameField = fillMatrix(scanner, initialData);
        int[] playerPos = Arrays.copyOfRange(initialData, 0, 2);
        int starsCount = initialData[2];
        int[] playerOldPos = Arrays.copyOfRange(playerPos, 0, playerPos.length);
        int pacmanHP = 100;
        boolean isImmune = false;

        String command = scanner.nextLine();

        while (!command.equals("END") && starsCount > 0 && pacmanHP > 0) {

            playerOldPos = Arrays.copyOfRange(playerPos, 0, playerPos.length);

            switch (command) {
                case "up" -> playerPos[0] -= 1;
                case "down" -> playerPos[0] += 1;
                case "left" -> playerPos[1] -= 1;
                case "right" -> playerPos[1] += 1;
            }

            if (!(isWithin(playerPos, gameField.length))) {
                if (playerPos[0] < 0) {
                    playerPos[0] = gameField.length - 1;
                } else if (playerPos[0] >= gameField.length) {
                    playerPos[0] = 0;
                } else if (playerPos[1] < 0) {
                    playerPos[1] = gameField.length - 1;
                } else if (playerPos[1] >= gameField.length) {
                    playerPos[1] = 0;
                }
            }

            if (gameField[playerPos[0]][playerPos[1]] == '*') {
                starsCount--;
                movePlayer(gameField, playerPos, playerOldPos);
            } else if (gameField[playerPos[0]][playerPos[1]] == 'G') {
                if (!isImmune) {
                    pacmanHP -= 50;
                } else {
                    isImmune = false;
                }
                movePlayer(gameField, playerPos, playerOldPos);
            } else if (gameField[playerPos[0]][playerPos[1]] == 'F') {
                isImmune = true;
                movePlayer(gameField, playerPos, playerOldPos);
            } else {
                movePlayer(gameField, playerPos, playerOldPos);
            }
            command = scanner.nextLine();
        }

        if (pacmanHP == 0) {
            System.out.printf("Game over! Pacman last coordinates [%d,%d]\n", playerPos[0], playerPos[1]);
        } else if (starsCount == 0) {
            System.out.println("Pacman wins! All the stars are collected.");
        } else {
            System.out.println("Pacman failed to collect all the stars.");
        }

        System.out.printf("Health: %d\n", pacmanHP);
        if (starsCount != 0) {
            System.out.printf("Uncollected stars: %d\n", starsCount);
        }
        print(gameField);
    }

    private static void movePlayer(char[][] gameField, int[] playerPos, int[] playerOldPos) {
        gameField[playerPos[0]][playerPos[1]] = 'P';
        gameField[playerOldPos[0]][playerOldPos[1]] = '-';
    }

    private static boolean isWithin(int[] playerPos, int fieldSize) {
        return playerPos[0] >= 0 && playerPos[0] < fieldSize && playerPos[1] >= 0 && playerPos[1] < fieldSize;
    }

    public static char[][] fillMatrix(Scanner scanner, int[] initialData) {

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            String rowData = scanner.nextLine().replace(" ", "");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = rowData.charAt(col);
                if (rowData.charAt(col) == 'P') {
                    initialData[0] = row;
                    initialData[1] = col;
                }
                if (rowData.charAt(col) == '*') {
                    initialData[2]++;
                }
            }
        }
        return matrix;
    }

    private static void print(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
