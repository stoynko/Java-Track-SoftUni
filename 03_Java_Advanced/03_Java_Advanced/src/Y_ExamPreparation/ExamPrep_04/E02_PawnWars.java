package Y_ExamPreparation.ExamPrep_04;

import java.util.*;

public class E02_PawnWars {

/*A chessboard has 8 rows and 8 columns. Rows also called ranks, are marked from number 1 to 8, and columns are marked from a to h. We have a total of 64 squares,
each square is represented by a combination of letters and a number (a1, b1, c1, etc.). In this problem colors of the board will be ignored.

We will play the game with two pawns white (w) and black (b), where they can:
    •	Only move forward:
        o	White (w) moves from the 1st rank to the 8th rank direction.
        o	Black (b) moves from 8th rank to the 1st rank direction.
    •	Can move only 1 square at a time.
    •	Can capture another pawn only diagonally:

When a pawn reaches the last rank, for white this is the 8th rank, and for black, this is the 1st rank, can be promoted to a queen.
Two pawns (w and b) will be placed on two random squares of the bord. The first move is always made by the white pawn (w), then black moves (b), then white (w) again, and so on.
When a pawn marches forward, the previous position is marked by "-" (dash).

Some rules will be applied when moving paws:
    •	If the two pawns interact diagonally, the player, in turn, must capture the opponent’s pawn.
         When a pawn capture another pawn the game is over and "Game over! {White/Black} capture on {coordinates}." is printed to the console.
Example: White pawn is on the move and captures black in "e5". We print "Game over! White capture on e5."

    •	If no capture is possible, the pawns keep on moving until one of them reaches the last rank.
    When one of the pawns reaches the last rank we print: "Game over! {White/Black} pawn is promoted to a queen at {coordinates}."

Example: It is black's turn and the pawn reaches the d1 square, we print "Game over! Black pawn is promoted to a queen at d1."

Constraints
    •	The input will be always valid.
    •	The matrix will always be 8x8.
    •	There will be no case where two pawns are placed on the same square.
    •	There will be no case where two pawns are placed on the same column.
    •	There will be no case where black/white will be placed on the last rank. */


    public static void main(String[] args) {

        char[][] chessboard = new char[8][8];
        int[] whitePos = new int[2];
        int[] prevWhitePos = whitePos;
        int[] blackPos = new int[2];
        int[] prevBlackPos = blackPos;
        setChessboard(chessboard, whitePos, blackPos, new Scanner(System.in));

        while (true) {

            if (isOnChessboard(whitePos[0] - 1, whitePos[1] - 1, chessboard) && chessboard[whitePos[0] - 1][whitePos[1] - 1] == 'b') {
                prevWhitePos = whitePos;
                whitePos = movePawn('w', whitePos[0] - 1, whitePos[1] - 1, prevWhitePos, chessboard);
                System.out.println(printWinner('w', "captured", whitePos, chessboard));
                return;
            } else if (isOnChessboard(whitePos[0] - 1, whitePos[1] + 1, chessboard) && chessboard[whitePos[0] - 1][whitePos[1] + 1] == 'b') {
                prevWhitePos = whitePos;
                whitePos = movePawn('w', whitePos[0] - 1, whitePos[1] + 1, prevWhitePos, chessboard);
                System.out.println(printWinner('w', "captured", whitePos, chessboard));
                return;
            } else if (isOnChessboard(whitePos[0] - 1, whitePos[1], chessboard) && whitePos[0] < 8) {
                prevWhitePos = whitePos;
                whitePos = movePawn('w', whitePos[0] - 1, whitePos[1], prevWhitePos, chessboard);
            } else {
                System.out.println(printWinner('w', "promoted", whitePos, chessboard));
                return;
            }

            if (isOnChessboard(blackPos[0] + 1, blackPos[1] - 1, chessboard) && chessboard[blackPos[0] + 1][blackPos[1] - 1] == 'w') {
                prevBlackPos = blackPos;
                blackPos = movePawn('b', blackPos[0] + 1, blackPos[1] - 1, prevBlackPos, chessboard);
                System.out.println(printWinner('b', "captured", blackPos, chessboard));
                return;
            } else if (isOnChessboard(blackPos[0] + 1, blackPos[1] + 1, chessboard) && chessboard[blackPos[0] + 1][blackPos[1] + 1] == 'w') {
                prevBlackPos = blackPos;
                blackPos = movePawn('b', blackPos[0] + 1, blackPos[1] + 1, prevBlackPos, chessboard);
                System.out.println(printWinner('w', "captured", blackPos, chessboard));
                return;
            } else if (isOnChessboard(blackPos[0] + 1, blackPos[1], chessboard) && blackPos[0] < 8) {
                prevBlackPos = blackPos;
                blackPos = movePawn('b', blackPos[0] + 1, blackPos[1], prevBlackPos, chessboard);
            } else {
                System.out.println(printWinner('b', "promoted", blackPos, chessboard));
                return;
            }

        }
    }

    private static String printWinner(char pawn, String outcome, int[] winnerPos, char[][] chessboard) {

        StringBuilder result = new StringBuilder();
        result.append("Game over! ");

        String winner = "";
        if (pawn == 'w') {
            winner = "White";
        } else if (pawn == 'b') {
            winner = "Black";
        }

        switch (outcome) {
            case "captured" -> {
                String position = getPosition(winnerPos[0], winnerPos[1], chessboard);
                result.append(winner).append(" capture on ").append(position).append(".");
            }
            case "promoted" -> {
                String position = getPosition(winnerPos[0], winnerPos[1], chessboard);
                result.append(winner).append(" pawn is promoted to a queen at ").append(position).append(".");
            }
        }

        return result.toString();
    }

    private static int[] movePawn(char pawn, int x, int y, int[] prevPawnPos, char[][] chessboard) {

        int prevX = prevPawnPos[0];
        int prevY = prevPawnPos[1];

        chessboard[prevX][prevY] = '-';
        chessboard[x][y] = pawn;

        return new int[]{x, y};
    }

    private static boolean isOnChessboard(int x, int y, char[][] chessboard) {
        return x >= 0 && x < chessboard.length && y >= 0 && y < chessboard.length;
    }

    private static String getPosition(int x, int y, char[][] chessboard) {

        StringBuilder position = new StringBuilder();
        position.append(((char) (97 + y)) + String.valueOf(8 - x));
        return position.toString();
    }

    private static void setChessboard(char[][] chessboard, int[] whitePos, int[] blackPos, Scanner scanner) {

        for (int row = 0; row < chessboard.length; row++) {
            String rowData = scanner.nextLine();
            for (int col = 0; col < chessboard.length; col++) {
                chessboard[row][col] = rowData.charAt(col);
                if (rowData.charAt(col) == 'w') {
                    whitePos[0] = row;
                    whitePos[1] = col;
                } else if (rowData.charAt(col) == 'b') {
                    blackPos[0] = row;
                    blackPos[1] = col;
                }
            }
        }
    }
}
