package C_Java_Advanced.B_MultidimensionalArrays;

import java.util.*;

public class E10_RadioactiveMutantVampireBunnies {

/*First, you will receive a line holding integers N and M, representing the rows and columns in the lair. Then you receive N strings that can only consist of ".", "B", "P".
The bunnies are marked with "B", the player is marked with "P", and everything else is free space, marked with a dot ".". They represent the initial state of the lair.
There will be only one player. Then you will receive a string with commands such as LLRRUUDD – where each letter represents the player's next move (Left, Right, Up, Down).
After each step of the player, each of the bunnies spread to the up, down, left, and right (neighboring cells marked as "." changes their value to B).
If the player moves to a bunny cell or a bunny reaches the player, the player has died. If the player goes out of the lair without encountering a bunny, the player has won.
When the player dies or wins, the game ends. All the activities for this turn continue (e.g., all the bunnies spread normally), but there are no more turns.
There will be no stalemates where the moves of the player end before he dies or escapes. Finally, print the final state of the lair with every row on a separate line.
On the last line, print either "dead: {row} {col}" or "won: {row} {col}".
Row and col are the coordinates of the cell where the player has died or the last cell he has been in before escaping the lair.

Input:
    •	On the first line of input, the numbers N and M are received – the number of rows and columns in the lair.
    •	On the next N lines, each row is received as a string. The string will contain only ".", "B", "P". All strings will be the same length. There will be only one "P" for all the input.
    •	On the last line, the directions are received in the form of a string containing "R", "L", "U", "D".
Output:
    •	On the first N lines, print the final state of the bunny lair.
    •	On the last line, print the outcome – "won: {row} {col}"  or "dead: {row} {col}".
Constraints
    •	The dimensions of the lair are in the range [3…20].
    •	The directions string length is in the range [1…20].*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] matrixDims = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixDims[0]);
        int cols = Integer.parseInt(matrixDims[1]);
        char[][] bunnyLair = new char[rows][cols];
        List<String> bunnyCoordinates = new ArrayList<>(fillMatrix(bunnyLair, scanner));
        int playerX = Integer.parseInt(bunnyCoordinates.get(0).split(":")[0]);
        int playerY = Integer.parseInt(bunnyCoordinates.get(0).split(":")[1]);
        bunnyCoordinates.remove(0);
        char[] directions = scanner.nextLine().toCharArray();
        int turn = 0;
        boolean playerLost = false;
        boolean playerWon = false;

        while (!playerLost || !playerWon) {

            switch (directions[turn++]) {
                case 'U' -> {
                    if (isPosValid(playerX - 1, playerY, bunnyLair)) {
                        bunnyLair[playerX][playerY] = '.';
                        playerX -= 1;
                        if (bunnyLair[playerX][playerY] == 'B') {
                            playerLost = true;
                        } else {
                            bunnyLair[playerX][playerY] = 'P';
                        }
                    } else {
                        bunnyLair[playerX][playerY] = '.';
                        playerWon = true;
                    }
                }
                case 'D' -> {
                    if (isPosValid(playerX + 1, playerY, bunnyLair)) {
                        bunnyLair[playerX][playerY] = '.';
                        playerX += 1;
                        if (bunnyLair[playerX][playerY] == 'B') {
                            playerLost = true;
                        } else {
                            bunnyLair[playerX][playerY] = 'P';
                        }
                    } else {
                        bunnyLair[playerX][playerY] = '.';
                        playerWon = true;
                    }
                }
                case 'L' -> {
                    if (isPosValid(playerX, playerY - 1, bunnyLair)) {
                        bunnyLair[playerX][playerY] = '.';
                        playerY -= 1;
                        if (bunnyLair[playerX][playerY] == 'B') {
                            playerLost = true;
                        } else {
                            bunnyLair[playerX][playerY] = 'P';
                        }
                    } else {
                        bunnyLair[playerX][playerY] = '.';
                        playerWon = true;
                    }
                }
                case 'R' -> {
                    if (isPosValid(playerX, playerY + 1, bunnyLair)) {
                        bunnyLair[playerX][playerY] = '.';
                        playerY += 1;
                        if (bunnyLair[playerX][playerY] == 'B') {
                            playerLost = true;
                        } else {
                            bunnyLair[playerX][playerY] = 'P';
                        }
                    } else {
                        bunnyLair[playerX][playerY] = '.';
                        playerWon = true;
                    }
                }
            }

            int bunnies = bunnyCoordinates.size();
            for (int i = 0; i < bunnies; i++) {

                String coordinate = bunnyCoordinates.get(0);
                bunnyCoordinates.remove(0);
                int bunnyX = Integer.parseInt(String.valueOf(coordinate.split(":")[0]));
                int bunnyY = Integer.parseInt(String.valueOf(coordinate.split(":")[1]));

                if (isPosValid(bunnyX - 1, bunnyY, bunnyLair)) {
                    if (bunnyLair[bunnyX - 1][bunnyY] == '.') {
                        bunnyLair[bunnyX - 1][bunnyY] = 'B';
                        bunnyCoordinates.add((bunnyX - 1) + ":" + bunnyY);
                    } else if (bunnyLair[bunnyX - 1][bunnyY] == 'P') {
                        bunnyLair[bunnyX - 1][bunnyY] = 'B';
                        playerLost = true;
                    }
                }
                if (isPosValid(bunnyX + 1, bunnyY, bunnyLair)) {
                    if (bunnyLair[bunnyX + 1][bunnyY] == '.') {
                        bunnyLair[bunnyX + 1][bunnyY] = 'B';
                        bunnyCoordinates.add((bunnyX + 1) + ":" + bunnyY);
                    } else if (bunnyLair[bunnyX + 1][bunnyY] == 'P') {
                        bunnyLair[bunnyX + 1][bunnyY] = 'B';
                        playerLost = true;
                    }
                }
                if (isPosValid(bunnyX, bunnyY - 1, bunnyLair)) {
                    if (bunnyLair[bunnyX][bunnyY - 1] == '.') {
                        bunnyLair[bunnyX][bunnyY - 1] = 'B';
                        bunnyCoordinates.add(bunnyX + ":" + (bunnyY - 1));
                    } else if (bunnyLair[bunnyX][bunnyY - 1] == 'P') {
                        bunnyLair[bunnyX][bunnyY - 1] = 'B';
                        playerLost = true;
                    }
                }
                if (isPosValid(bunnyX, bunnyY + 1, bunnyLair)) {
                    if (bunnyLair[bunnyX][bunnyY + 1] == '.') {
                        bunnyLair[bunnyX][bunnyY + 1] = 'B';
                        bunnyCoordinates.add(bunnyX + ":" + (bunnyY + 1));
                    } else if (bunnyLair[bunnyX][bunnyY + 1] == 'P') {
                        bunnyLair[bunnyX][bunnyY + 1] = 'B';
                        playerLost = true;
                    }
                }
            }
            if (playerWon || playerLost) {
                break;
            }
        }
        printMatrix(bunnyLair);
        if (playerWon) {
            System.out.printf("won: %d %d\n", playerX, playerY);
        } else {
            System.out.printf("dead: %d %d\n", playerX, playerY);
        }
    }

    private static boolean isPosValid(int x, int y, char[][] matrix) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }

    private static List<String> fillMatrix(char[][] matrix, Scanner scanner) {

        List<String> bunnyCoordinates = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            String input = scanner.nextLine();
            for (int column = 0; column < matrix[0].length; column++) {
                char symbol = input.charAt(column);
                matrix[row][column] = symbol;
                if (symbol == 'B') {
                    bunnyCoordinates.add(row + ":" + column);
                } else if (symbol == 'P') {
                    bunnyCoordinates.add(0, row + ":" + column);
                }
            }
        }
        return bunnyCoordinates;
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.printf("%s", matrix[row][column]);
            }
            System.out.println();
        }
    }
}