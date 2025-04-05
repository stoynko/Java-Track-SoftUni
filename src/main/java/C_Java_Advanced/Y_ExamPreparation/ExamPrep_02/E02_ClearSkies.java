package C_Java_Advanced.Y_ExamPreparation.ExamPrep_02;

import java.util.*;

public class E02_ClearSkies {

/*You will be given an integer n for the size of the protected airspace (square shape). On the next lines, you will receive the rows of the airspace.
The jetfighter will start at a random position, marked with the letter 'J'. The jetfighter surveys the surrounding area for enemy aircraft.
The jetfighter initially has 300 units of armour. When it receives a direction, it moves one position towards the given direction.
On each turn, you will be guiding the jetfighter and giving it the direction, in which it should move. The commands will be "up", "down", "left" and "right".
•	If a position with '-' (dash) is reached, it means that the field is empty and the jetfighter awaits its next direction.
•	If it encounters an enemy aircraft marked with 'E' battle begins. The jetfighter shoots down the enemy plane
(the position of the destroyed enemy plane will be marked with '-' (dash)) and your plane takes damage – its armour loses 100 units.
It can withstand two hits from enemy planes. The third time the jetfighter is hit by an enemy plane, it crashes and the mission fails.
The following message should be printed on the console: "Mission failed, your jetfighter was shot down! Last coordinates [{row}, {col}]!"

Note that the last enemy plane has no armament and does no damage to your jetfighter.
•	If a position marked with 'R' is reached your plane is repaired and restores 300 units of its armor. The position must be marked with '-' (dash).
In case your plane has not taken any damage and lands on a field marked with 'R' nothing happens the field just needs to be '-' (dash)-marked again.
•	If your jetfighter succeeded in shooting down all enemy planes the following message should be printed on the console: "Mission accomplished, you neutralized the aerial threat!"
The program will end when the battle ends (аll enemy planes are shot down or your jetfighter armor becomes 0 /zero/).

Input:
    •	On the first line, you are given the integer n – the size of the matrix (airspace).
    •	The next n lines hold the values for every row.
    •	On each of the next lines, you will get a direction command.
Output:
    •	If all enemy planes are shot down, print:
        o	"Mission accomplished, you neutralized the aerial threat!"
    •	If your jetfighter is hit by an enemy plane three times, print:
        o	"Mission failed, your jetfighter was shot down! Last coordinates [{row}, {col}]!".
    •	At the end, print the final state of the matrix (airspace) with the last known position of your jetfighter on it.

Constraints:
    •	The size of the square matrix (airspace) will be between [4…10].
    •	The jetfighter starting position will always be marked with 'J'.
    •	There will be always four enemy aircraft - fields marked with 'E'.
    •	There will be always a random count (1…5) fields marked with 'R' (repair).
    •	The commands given will direct the jetfighter only within the limits of the matrix (airspace).
    •	There will be always two output scenarios - either the enemy shoots down your plane or your plane shoots down all the enemy planes.
    •	You will always receive enough commands to end the battle. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] playerPos = new int[2];
        int enemyJets = 4;
        char[][] airspace = fillMatrix(scanner, playerPos);
        int[] playerOldPos = Arrays.copyOfRange(playerPos, 0, playerPos.length);
        int playerArmor = 300;

        while (playerArmor > 0 && enemyJets > 0) {

            String command = scanner.nextLine();
            playerOldPos = Arrays.copyOfRange(playerPos, 0, playerPos.length);
            switch (command) {
                case "up" -> playerPos[0] -= 1;
                case "down" -> playerPos[0] += 1;
                case "left" -> playerPos[1] -= 1;
                case "right" -> playerPos[1] += 1;
            }

            if (airspace[playerPos[0]][playerPos[1]] == '-') {
                airspace[playerPos[0]][playerPos[1]] = 'J';
                airspace[playerOldPos[0]][playerOldPos[1]] = '-';
            } else if (airspace[playerPos[0]][playerPos[1]] == 'E') {
                playerArmor -= 100;
                enemyJets -= 1;
                airspace[playerPos[0]][playerPos[1]] = 'J';
                airspace[playerOldPos[0]][playerOldPos[1]] = '-';
            } else if (airspace[playerPos[0]][playerPos[1]] == 'R') {
                playerArmor = 300;
                airspace[playerPos[0]][playerPos[1]] = 'J';
                airspace[playerOldPos[0]][playerOldPos[1]] = '-';
            }
        }

        System.out.println(enemyJets == 0 ?
                "Mission accomplished, you neutralized the aerial threat!" :
                String.format("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!", playerPos[0], playerPos[1]));
    print(airspace, playerPos);
    }


    public static char[][] fillMatrix(Scanner scanner, int[] playerPos) {

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            String rowData = scanner.nextLine().replace(" ", "");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = rowData.charAt(col);
                if (rowData.charAt(col) == 'J') {
                    playerPos[0] = row;
                    playerPos[1] = col;
                }
            }
        }
        return matrix;
    }

    private static void print(char[][] matrix, int[] playerPos) {
        matrix[playerPos[0]][playerPos[1]] = 'J';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}