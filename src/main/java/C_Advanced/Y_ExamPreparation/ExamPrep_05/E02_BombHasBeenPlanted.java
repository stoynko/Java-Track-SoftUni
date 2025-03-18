package C_Advanced.Y_ExamPreparation.ExamPrep_05;

import java.util.*;

public class E02_BombHasBeenPlanted {

/*You will be given two, comma and space-separated, integer values, representing the dimensions (N and M) of a map with a rectangular shape. Following this,
you will receive the N count lines, each containing M count characters describing the map's initial layout. The mission of the counter-terrorist is to defuse the bomb successfully.
On the way, he might have to face some terrorists. When the bomb is defused the mission is accomplished and the counter-terrorist wins!
The counter-terrorist must complete his mission in 16 seconds, or the bomb will explode.

The map will contain randomly positioned elements - a counter-terrorist, terrorists, a bomb, and "empty" spaces:
    •	A counter-terrorist will be placed randomly, marked with the letter 'C'
    •	There will be some terrorists placed somewhere on the map, marked with the letter 'T'
    •	There will be a bomb, marked with the letter 'B'
    •	All the empty positions will be marked with '*'

Commands are received until:
    •	the counter-terrorist defuses the bomb
    •	OR is killed by a terrorist
    •	OR the bomb explodes

You will be given commands for the counter-terrorist's movement. The move commands will be "left", "right", "up", and "down". A "defuse" command is also possible.
The counter-terrorist starts moving only if he has enough time. Be careful, for every move command 1-second passes! If the time is over, the bomb explodes,
no matter where the counter-terrorist is positioned, and the program ends.
    •	If he steps on a '*' nothing happens and the program should continue running.
    •	If he steps on a 'B' the bomb is ready to be defused if a proper command ("defuse") is received next. If the next command is different from "defuse", the movement continues.
    •	If he steps on a 'T' the counter-terrorist is killed. Both disappear from the map and the position is marked with '*'.  The program ends.
    •	If he receives a command to step outside the map, the counter-terrorist remains in position without taking a step. Time keeps ticking away!

The "defuse" command:
    •	If the counter-terrorist is in a position different from the bomb's position, skip the command. 2 seconds have passed.
    •	If the counter-terrorist is placed at the same coordinates as the bomb he starts defusing. The defuse time is 4 seconds:
        o	If he successfully defuses it (there are 0 or more remaining seconds after defusing), the position is marked with 'D', and the program ends.
        o	Else, counter-terrorist is dead. Both, the bomb and counter-terrorist disappear from the map, and the position is marked with 'X'.

In the end, print the final state of the map, with the counter-terrorist in his starting position.

Input:
    •	On the first line, you are given two integer values, separated by a comma and space – the dimensions (rows, columns) of a rectangular-shaped matrix
    •	The next rows count lines contain the values (string format) for every matrix row.
    •	After that, you will get commands (each one on a new line).
Output:

At the end of the program:
    •	If the bomb has exploded OR the counter-terrorist was defusing and did NOT have enough time, calculate the time needed for successful defuse and print on the console:
        o	"Terrorists win!"
        o	"Bomb was not defused successfully!"
        o	"Time needed: {needed_time_for_bomb_defuse} second/s."
        !	Note: The counter-terrorist defuses the bomb only if the bomb's position is the same as the counter-terrorist position and the command "defuse" is given.
            The needed time for bomb defuse will be 0 (zero) if the counter-terrorist is not defusing it. See the Examples section.
    •	If the counter-terrorist successfully defused the bomb, track the time left and print on the console:
        o	"Counter-terrorist wins!"
        o	" Bomb has been defused: {remaining_seconds} second/s remaining."
    •	If the counter-terrorist was killed by a terrorist print on the console:
        o	"Terrorists win!"
    •	Finally, print the matrix in its final state. Remember to put the counter-terrorist in his initial position.

Constraints:
    •	The dimensions of the matrix (map) will be in the range [2…10].
    •	Only the letters 'C', 'T', and 'B' will be present on the map, initially.
    •	There will always be enough commands to finish the program. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] bombSiteDimensions = scanner.nextLine().split(", ");
        char[][] bombSite = new char[Integer.parseInt(bombSiteDimensions[0])][Integer.parseInt(bombSiteDimensions[1])];
        int timer = 16;
        int timeToDefuse = 4;
        int timePenalty = 2;
        int[] coordinates = fillMatrix(bombSite, scanner);
        int[] playerPos = Arrays.copyOfRange(coordinates, 0, 2);
        int[] bombPos = Arrays.copyOfRange(coordinates, 2, coordinates.length);
        int[] playerInitPos = Arrays.copyOfRange(playerPos, 0, playerPos.length);
        int[] playerNewPos = Arrays.copyOfRange(playerPos, 0, playerPos.length);
        boolean canDefuse = false;

        while (timer > 0) {

            String command = scanner.nextLine();

            switch (command) {
                case "up" -> playerNewPos[0] -= 1;
                case "down" -> playerNewPos[0] += 1;
                case "left" -> playerNewPos[1] -= 1;
                case "right" -> playerNewPos[1] += 1;
                case "defuse" -> {
                    if (Arrays.equals(playerPos, bombPos) && canDefuse) {
                        timer -= timeToDefuse;
                        if (timer >= 0) {
                            if (!(Arrays.equals(playerPos, playerInitPos))) {
                                bombSite[playerPos[0]][playerPos[1]] = '*';
                            }
                            bombSite[playerInitPos[0]][playerInitPos[1]] = 'C';
                            bombSite[bombPos[0]][bombPos[1]] = 'D';
                            System.out.println("Counter-terrorist wins!");
                            System.out.printf("Bomb has been defused: %d second/s remaining.\n", timer);
                            print(bombSite);
                            return;
                        }
                    } else {
                        timer -= timePenalty;
                    }
                    continue;
                }
            }

            if (isWithin(playerNewPos[0], playerNewPos[1], bombSite)) {
                if (Arrays.equals(playerNewPos, bombPos)) {
                    canDefuse = true;
                } else if (bombSite[playerNewPos[0]][playerNewPos[1]] == 'T') {
                    bombSite[playerPos[0]][playerPos[1]] = '*';
                    bombSite[playerNewPos[0]][playerNewPos[1]] = '*';
                    System.out.println("Terrorists win!");
                    bombSite[playerInitPos[0]][playerInitPos[1]] = 'C';
                    bombSite[bombPos[0]][bombPos[1]] = 'B';
                    print(bombSite);
                    return;
                }
                bombSite[playerNewPos[0]][playerNewPos[1]] = 'C';
                if (Arrays.equals(playerPos, bombPos)) {
                    bombSite[playerPos[0]][playerPos[1]] = 'B';
                } else {
                    bombSite[playerPos[0]][playerPos[1]] = '*';
                }
                playerPos = Arrays.copyOfRange(playerNewPos, 0, playerPos.length);
            } else {
                playerNewPos = Arrays.copyOfRange(playerPos, 0, playerPos.length);
            }
            timer--;
        }
        bombSite[playerInitPos[0]][playerInitPos[1]] = 'C';
        System.out.println("Terrorists win!");
        System.out.println("Bomb was not defused successfully!");
        System.out.printf("Time needed: %d second/s.\n", Math.abs(timer));
        if (!(Arrays.equals(playerPos, playerInitPos))) {
            bombSite[playerPos[0]][playerPos[1]] = '*';
        }
        if ((Arrays.equals(playerPos, bombPos))) {
            bombSite[bombPos[0]][bombPos[1]] = 'X';
        }
        print(bombSite);
    }

    private static boolean isWithin(int playerX, int playerY, char[][] matrix) {
        return playerX >= 0 && playerX < matrix.length && playerY >= 0 && playerY < matrix[0].length;
    }

    private static int[] fillMatrix(char[][] matrix, Scanner scanner) {
        int[] playerPos = new int[4];

        for (int row = 0; row < matrix.length; row++) {
            String rowData = scanner.nextLine();
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = rowData.charAt(col);
                if (rowData.charAt(col) == 'C') {
                    playerPos[0] = row;
                    playerPos[1] = col;
                }
                if (rowData.charAt(col) == 'B') {
                    playerPos[2] = row;
                    playerPos[3] = col;
                }
            }
        }
        return playerPos;
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

