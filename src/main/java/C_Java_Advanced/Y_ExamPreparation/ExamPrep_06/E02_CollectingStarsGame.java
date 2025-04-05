package C_Java_Advanced.Y_ExamPreparation.ExamPrep_06;

import java.util.*;

public class E02_CollectingStarsGame {

/*On the first line, you will be given an integer N, representing the size of the field with a square shape. On the following N lines,
you will be given the field containing symbols, separated by a single space. See the Examples section.
Your goal is to collect 10 stars.

The field will contain randomly positioned elements - a player, stars, and obstacles:
    •	One player, marked with the letter "P"
    •	Stars, marked with the asterisk symbol "*"
    •	Obstacles marked with hashtag symbol "#"
There are two possible outcomes of the game and commands are received until:
    •	The player collects 10 stars and wins the game.
    •	The player hits obstacles, loses all his stars, and loses the game.

After the field state, you will be given commands for the player's movement. Commands can be: "up", "down", "left", or "right".
The player starts the game with 2 stars initially  2 and moves in the given direction with one step for each command,
collecting all the stars he comes across or losing a star each time he hits an obstacle. The player can go through the same path many times but can
collect the stars just once (the first time), while the obstacles are immovable and will remain there.
The player can hit the same obstacle many times and lose a star each time that happens.

Game rules:
    •	When the player comes across a star and collects it, the cell shall be marked with a dot ".".
        o	The total number of collected stars shall be increased by one.  +1
    •	If the player encounters an obstacle, he does not move and remains in his current position.
        o	The player loses one star each time he hits an obstacle.  -1
    •	If the player steps out of the field, he will be punished by a teleport to the field's starting position ( coordinates [0, 0]).
    •	When the player makes his first move, mark his initial position with a dot ".".
    •	The game continues until the player manages to collect 10 stars and wins or until he loses all his stars by hitting obstacles and therefore loses the game.
    •	At the end of the game, print the final state of the field and the player's final position, marked with "P".

Input
    •	On the first line you will receive an integer N representing the size of the square field (matrix NxN).
    •	On the next N lines you will get the field rows (each position separated by a single space)
    •	On each of the following lines, you will get a valid move command.

Output:
At the end of the program:
    •	If the player won the game, print: "You won! You have collected 10 stars."
    •	If the player loses the game, print: "Game over! You are out of any stars."
    •	Next, print the player's final position: "Your final position is [{row_position}, {column_position}]"
    •	Finally, print the matrix in its final state, each position separated by a single space. Remember to mark the player's final position with "P".

Constraints:
    •	There will always be enough commands to either win or lose the game.
    •	There will be no case in which less than 10 stars will be in the field.
    •	There will be no obstacle at the field's starting position (coordinates [0,0])
    •	All given symbols will be valid following the description. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int collectedStars = 2;
        int[] playerPos = new int[2];
        char[][] matrix = fillMatrix(scanner, playerPos);
        int [] playerOldPos = Arrays.copyOfRange(playerPos, 0, 2);
        boolean hasWon = false;

        while (true) {

            if (collectedStars == 10) {
                hasWon = true;
                break;
            } else if (collectedStars == 0) {
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

            if (isWithin(playerPos, matrix.length)) {
                if (matrix[playerPos[0]][playerPos[1]] == '*') {
                    matrix[playerPos[0]][playerPos[1]] = 'P';
                    matrix[playerOldPos[0]][playerOldPos[1]] = '.';
                    collectedStars += 1;
                } else if (matrix[playerPos[0]][playerPos[1]] == '#') {
                    collectedStars -= 1;
                    playerPos = Arrays.copyOfRange(playerOldPos, 0, playerPos.length);
                } else {
                    matrix[playerPos[0]][playerPos[1]] = 'P';
                    matrix[playerOldPos[0]][playerOldPos[1]] = '.';
                }
            } else {
                playerPos[0] = 0;
                playerPos[1] = 0;
                if (matrix[playerPos[0]][playerPos[1]] == '*') {
                    matrix[playerPos[0]][playerPos[1]] = 'P';
                    matrix[playerOldPos[0]][playerOldPos[1]] = '.';
                    collectedStars += 1;
                } else if (matrix[playerPos[0]][playerPos[1]] == '#') {
                    collectedStars -= 1;
                    playerPos = Arrays.copyOfRange(playerOldPos, 0, playerPos.length);
                } else if (matrix[playerPos[0]][playerPos[1]] == '.'){
                    matrix[playerPos[0]][playerPos[1]] = 'P';
                    matrix[playerOldPos[0]][playerOldPos[1]] = '.';
                }
            }
        }

        System.out.println(hasWon ? "You won! You have collected 10 stars." : "Game over! You are out of any stars.");
        System.out.printf("Your final position is [%d, %d]\n", playerPos[0], playerPos[1]);
        print(matrix, playerPos);
    }

    private static boolean isWithin(int[] playerPos, int n) {
        return playerPos[0] >= 0 && playerPos[0] < n && playerPos[1] >= 0 && playerPos[1] < n;
    }

    public static char[][] fillMatrix(Scanner scanner, int[] playerPos) {

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
            }
        }
        return matrix;
    }

    private static void print(char[][] matrix, int[] playerPos) {
        matrix[playerPos[0]][playerPos[1]] = 'P';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
