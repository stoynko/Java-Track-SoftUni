package C_Advanced.Y_ExamPreparation.ExamPrep_08;

import java.util.*;

public class E02_FishingCompetition {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] playerPos = new int[2];
        char[][] fishingArea = fillMatrix(scanner, playerPos);
        int[] playerOldPos = Arrays.copyOfRange(playerPos, 0, playerPos.length);
        int catchedFish = 0;
        boolean hasSunken = false;
        String input = scanner.nextLine();

        while (!input.equals("collect the nets")) {

            playerOldPos = Arrays.copyOfRange(playerPos, 0, playerPos.length);

            switch (input) {
                case "up" -> playerPos[0] -= 1;
                case "down" -> playerPos[0] += 1;
                case "left" -> playerPos[1] -= 1;
                case "right" -> playerPos[1] += 1;
            }

            if (!(isWithin(playerPos, fishingArea.length))) {
                if (playerPos[0] < 0) {
                    playerPos[0] = fishingArea.length - 1;
                } else if (playerPos[0] >= fishingArea.length) {
                    playerPos[0] = 0;
                } else if (playerPos[1] < 0) {
                    playerPos[1] = fishingArea.length - 1;
                } else if (playerPos[1] >= fishingArea.length) {
                    playerPos[1] = 0;
                }
            }

            if (Character.isDigit(fishingArea[playerPos[0]][playerPos[1]])) {
                catchedFish += Character.getNumericValue(fishingArea[playerPos[0]][playerPos[1]]);
                fishingArea[playerPos[0]][playerPos[1]] = 'S';
                fishingArea[playerOldPos[0]][playerOldPos[1]] = '-';
            } else if (fishingArea[playerPos[0]][playerPos[1]] == 'W') {
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                        "Last coordinates of the ship: [%d,%d]", playerPos[0], playerPos[1]);
                return;
            } else if (fishingArea[playerPos[0]][playerPos[1]] == '-') {
                fishingArea[playerPos[0]][playerPos[1]] = 'S';
                fishingArea[playerOldPos[0]][playerOldPos[1]] = '-';
            }
            input = scanner.nextLine();
        }

        if (catchedFish >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.\n", 20 - catchedFish);
        }
        if (catchedFish > 0) {
            System.out.printf("Amount of fish caught: %d tons.\n", catchedFish);
        }
        print(fishingArea);
    }

    public static char[][] fillMatrix(Scanner scanner, int[] playerPos) {

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            String rowData = scanner.nextLine().replace(" ", "");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = rowData.charAt(col);
                if (rowData.charAt(col) == 'S') {
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
