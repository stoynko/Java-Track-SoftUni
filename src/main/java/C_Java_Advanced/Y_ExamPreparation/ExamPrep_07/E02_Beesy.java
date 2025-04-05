package C_Java_Advanced.Y_ExamPreparation.ExamPrep_07;

import java.util.*;

public class E02_Beesy {

/*You will be given an integer n for the size of the field with a square shape. On the next n lines, you will receive the rows of the field.
    •	Your bee will be placed in a random position, marked with the letter 'B'.
    •	There will be flowers with nectar which need to be pollinated on random positions, marked with a single digit.
    •	There will be a hive, marked with the letter 'H'.
    •	All of the empty positions will be marked with '-'.

The bee will have 15 units of energy initially. A command is received each turn until the bee runs out of energy or reaches the hive.
The bee must collect and take at least 30 units of nectar to the hive. This would be the required quantity to make honey successfully.
Keep in mind that even if the needed amount of nectar is collected, but the hive is not reached the bee continues to move according to the commands.
You will be given commands for the bee's movement. The commands will be: "up", "down", "left", and "right". The bee moves towards the given direction.
With each move, the bee's energy decreases by 1 unit.
    •	If the bee leaves the field (goes out of the boundaries of the matrix) depending on the move command,
        it will be moved to the opposite side of the field.

Example: In a 3x3 matrix the bee is at position [1,2] and receives the command "right" it will be moved to position [1,0].
    •	If the bee moves to a flower (a position marked with a digit), it collects the nectar
        (the value of the digit is added to the total amount of collected nectar) the flower disappears and should be replaced by '-'.
    •	If the bee runs out of energy, and the total amount of collected nectar is less than 30 units, the program ends.
        The correct output should be printed on the Console.
    •	If the bee runs out of energy and the total amount of collected nectar is at least 30 units, the energy will be restored with the amount of the
        difference between the nectar collected up to this turn and the minimum required amount for making honey (30).
        The value of the collected nectar is dropped to 30 units. The energy can be restored only once.

Example: Collected nectar is equal to 40 units. 40 – 30 = 10. The bee's energy is increased by 10, the nectar is decreased to 30 units. Hint: Check for zero energy after restoration.
    o	The next time the bee runs out of energy, the movement discontinues. The program ends.
        The correct output should be printed on the Console.
        •	If the bee reaches a position, marked with  'H', the hive is reached and the program ends.
        Hint: If reaching the hive with zero energy, the success will depend on the amount of the collected nectar. The correct output should be printed on the Console.
Input:
    •	On the first line, you are given the integer n – the size of the square matrix.
    •	The next n lines hold the values for every matrix row.
    •	After that, you will get a move command on each of the next lines.

Output:
    •	On the first line:
        o	If the bee reaches the hive with at least 30 units of nectar collected, print this message and stop the program:
            "Great job, Beesy! The hive is full. Energy left: {energy}"
        o	If the bee reaches the hive but has not succeeded in collecting at least 30 units of nectar:
        "Beesy did not manage to collect enough nectar."
         o	If the bee runs out of energy, before returning to the hive:
            "This is the end! Beesy ran out of energy."

    •	On the next lines.
        o	Print the final state of the matrix, with the last known position of the bee, marked with 'B'.

Constraints:
    •	The size of the square matrix (field) will be between [2…10].
    •	Only the letters 'B' and 'H' will be present in the matrix.
    •	The flowers with nectar are represented by single positive digits between [0…9].
    •	There will always be enough commands to finish the program. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] playerPos = new int[2];
        char[][] field = fillMatrix(scanner, playerPos);
        int[] playerOldPos = Arrays.copyOfRange(playerPos, 0, playerPos.length);
        int energy = 15;
        int nectar = 0;
        boolean hasEnergy = true;
        boolean hasRestoredEnergy = false;
        boolean hasReturned = false;

        while (true) {

            if (energy == 0 && nectar >= 30 && !hasRestoredEnergy) {
                int energyRefill = nectar - 30;
                nectar -= energyRefill;
                energy += energyRefill;
                hasRestoredEnergy = true;
            }

            if (energy == 0) {
                hasEnergy = false;
                break;
            }

            String command = scanner.nextLine();
            playerOldPos = Arrays.copyOfRange(playerPos, 0, playerPos.length);

            switch (command) {
                case "up" -> playerPos[0] -= 1;
                case "down" -> playerPos[0] += 1;
                case "left" -> playerPos[1] -= 1;
                case "right" -> playerPos[1] += 1;
            }

            if (!(isWithin(playerPos, field.length))) {
                if (playerPos[0] < 0) {
                    playerPos[0] = field.length - 1;
                } else if (playerPos[0] >= field.length) {
                    playerPos[0] = 0;
                } else if (playerPos[1] < 0) {
                    playerPos[1] = field.length - 1;
                } else if (playerPos[1] >= field.length) {
                    playerPos[1] = 0;
                }
            }

            if (Character.isDigit(field[playerPos[0]][playerPos[1]])) {
                nectar += Character.getNumericValue(field[playerPos[0]][playerPos[1]]);
                field[playerPos[0]][playerPos[1]] = 'B';
                field[playerOldPos[0]][playerOldPos[1]] = '-';
            } else if (field[playerPos[0]][playerPos[1]] == '-') {
                field[playerPos[0]][playerPos[1]] = 'B';
                field[playerOldPos[0]][playerOldPos[1]] = '-';
            } else if (field[playerPos[0]][playerPos[1]] == 'H') {
                hasReturned = true;
                field[playerPos[0]][playerPos[1]] = 'B';
                field[playerOldPos[0]][playerOldPos[1]] = '-';
                energy--;
                break;
            }
            energy--;
        }

        if (!hasEnergy) {
            System.out.println("This is the end! Beesy ran out of energy.");
        } else if (hasReturned) {
            if (nectar >= 30) {
                System.out.printf("Great job, Beesy! The hive is full. Energy left: %d\n", energy);
            } else {
                System.out.println("Beesy did not manage to collect enough nectar.");
            }
        }
        print(field);
    }

    public static char[][] fillMatrix(Scanner scanner, int[] playerPos) {

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            String rowData = scanner.nextLine().replace(" ", "");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = rowData.charAt(col);
                if (rowData.charAt(col) == 'B') {
                    playerPos[0] = row;
                    playerPos[1] = col;
                }
            }
        }
        return matrix;
    }

    private static boolean isWithin(int[] playerPos, int fieldSize) {
        return playerPos[0] >= 0 && playerPos[0] < fieldSize && playerPos[1] >= 0 && playerPos[1] < fieldSize;
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
