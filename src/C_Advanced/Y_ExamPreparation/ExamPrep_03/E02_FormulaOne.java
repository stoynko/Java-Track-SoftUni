package C_Advanced.Y_ExamPreparation.ExamPrep_03;

import java.util.*;

public class E02_FormulaOne {

/*You will be given an integer N for the size of the square matrix and then an integer for the count of commands. On the next n lines, you will receive the rows of the matrix.
The player starts at a random position (the player is marked with "P") and all of the empty slots will be filled with "." (dot). The goal is to reach the finish mark which
will be marked with an "F". On the field, there can also be bonuses and traps. Bonuses are marked with "B" and traps are marked with "T".

Each turn you will be given commands for the player’s movement. If the player goes out of the matrix, he comes in from the other side. For example,
if the player is on 0, 0 and the next command is left, he goes to the last spot on the first row. If the player steps on a bonus, he should move another step forward in the
direction he is going. If the player steps on a trap, he should move a step backward. When the player reaches the finish mark or the count of commands is reached, the game ends.

Input:
    •	On the first line, you are given the integer N – the size of the square matrix.
    •	On the second you are given the count of commands.
    •	The next N lines hold the values for every row.
    •	On each of the next lines, you will get commands for movement directions.
Output:
    •	If the player reaches the finish mark, print:
        o	"Well done, the player won first place!"
    •	If the player reaches the commands count and hasn’t reached the finish mark print:
        o	"Oh no, the player got lost on the track!"
    •	At the end print the matrix.
Constraints:
    •	The size of the matrix will be between [2…20].
    •	The players will always be indicated with "P".
    •	If the player steps on the finish mark at the same time as his last command, he wins the game.
    •	When the final matrix is printed and the vehicle has been completed successfully, you must replace the "F" with the "P".
    •	Commands will be in the format of up, down, left or right.
    •	There won't be a case where you bypass the finish while you are on a trap or a bonus.
    •	A trap will never place you into a bonus or another trap and a bonus will never place you into a trap or another bonus. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] raceTrack = new char[rows][rows];
        int[] playerPos = fillMatrix(raceTrack, scanner);
        boolean playerWon = false;

        for (int currentCommand = 1; currentCommand <= commandsCount; currentCommand++) {

            String command = scanner.nextLine();
            switch (command) {
                case "up" -> {
                    playerPos = movePlayer(command, playerPos, playerPos[0] - 1, playerPos[1], raceTrack);
                    playerWon = hasReachedFinishLine(playerPos[0], playerPos[1], raceTrack);
                }
                case "down" -> {
                    playerPos = movePlayer(command, playerPos, playerPos[0] + 1, playerPos[1], raceTrack);
                    playerWon = hasReachedFinishLine(playerPos[0], playerPos[1], raceTrack);
                }
                case "left" -> {
                    playerPos = movePlayer(command, playerPos, playerPos[0], playerPos[1] - 1, raceTrack);
                    playerWon = hasReachedFinishLine(playerPos[0], playerPos[1], raceTrack);
                }
                case "right" -> {
                    playerPos = movePlayer(command, playerPos, playerPos[0], playerPos[1] + 1, raceTrack);
                    playerWon = hasReachedFinishLine(playerPos[0], playerPos[1], raceTrack);
                }
            }
            if (playerWon) {
                break;
            }
        }

        System.out.println(playerWon ? "Well done, the player won first place!" : "Oh no, the player got lost on the track!");
        raceTrack[playerPos[0]][playerPos[1]] = 'P';
        print(raceTrack);
    }

    private static boolean hasReachedFinishLine(int x, int y, char[][] raceTrack) {
        return raceTrack[x][y] == 'F';
    }

    private static int[] movePlayer(String direction, int[] playerPos, int x, int y, char[][] raceTrack) {

        if (isWithinRaceTrack(x, y, raceTrack)) {
            raceTrack[playerPos[0]][playerPos[1]] = '.';
            if (raceTrack[x][y] != 'B' && raceTrack[x][y] != 'T' && raceTrack[x][y] != 'F') {
                raceTrack[x][y] = 'P';
            } else if (raceTrack[x][y] == 'B') {
                switch (direction) {
                    case "up" -> x--;
                    case "down" -> x++;
                    case "left" -> y--;
                    case "right" -> y++;
                }
                if (!isWithinRaceTrack(x, y, raceTrack)) {
                    switch (direction) {
                        case "up" -> x = raceTrack.length - 1;
                        case "down" -> x = 0;
                        case "left" -> y = raceTrack.length - 1;
                        case "right" -> y = 0;
                    }
                }
                if (raceTrack[x][y] != 'B' && raceTrack[x][y] != 'T' && raceTrack[x][y] != 'F') {
                    raceTrack[x][y] = 'P';
                }
            } else if (raceTrack[x][y] == 'T') {
                switch (direction) {
                    case "up" -> x++;
                    case "down" -> x--;
                    case "left" -> y++;
                    case "right" -> y--;
                }
                raceTrack[x][y] = 'P';
            }
        } else {
            raceTrack[playerPos[0]][playerPos[1]] = '.';
            switch (direction) {
                case "up" -> x = raceTrack.length - 1;
                case "down" -> x = 0;
                case "left" -> y = raceTrack.length - 1;
                case "right" -> y = 0;
            }
            raceTrack[x][y] = 'P';
        }
        playerPos[0] = x;
        playerPos[1] = y;
        return playerPos;
    }

    private static boolean isWithinRaceTrack(int x, int y, char[][] raceTrack) {
        return x >= 0 && x < raceTrack.length && y >= 0 && y < raceTrack.length;
    }

    private static void print(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[] fillMatrix(char[][] matrix, Scanner scanner) {
        int[] playerPos = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            String rowData = scanner.nextLine();
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = rowData.charAt(col);
                if (rowData.charAt(col) == 'P') {
                    playerPos[0] = row;
                    playerPos[1] = col;
                }
            }
        }
        return playerPos;
    }
}
