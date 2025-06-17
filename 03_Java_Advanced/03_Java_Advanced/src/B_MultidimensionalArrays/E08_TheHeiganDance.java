package B_MultidimensionalArrays;

import java.util.*;

public class E08_TheHeiganDance {

/*At last, level 80. And what do level eighties do? Go raiding. This is where you are now – trying not to be wiped by the famous dance boss, Heigan the Unclean.
The fight is pretty straightforward - dance around the Plague Clouds and Eruptions, and you'll be just fine.
Heigan's chamber is a 15-by-15 two-dimensional array. The player always starts at the exact center. For each turn,
Heigan uses a spell that hits a certain cell and the neighboring rows/columns. For example, if he hits (1,1), he also hits (0,0, 0,1, 0,2, 1,0 … 2,2).
If the player's current position is within the area of damage, the player tries to move. First, he tries to move up. If there's damage/wall, he tries to move right, down, and left.
If he cannot move in any direction because the cell is damaged or there is a wall, the player stays in place and takes the damage.
Plague cloud does 3500 damage when it hits, and 3500 damage the next turn. Then it expires. Eruption does 6000 damage when it hits.
If a spell hits a player that also has an active Plague Cloud from the previous turn, the cloud damage is applied first. Both Heigan and the player may die in the same turn.
If Heigan is dead, the spell he would have cast is ignored.
The player always starts at 18500 hit points; Heigan starts at 3,000,000 hit points. Each turn, the player does damage to Heigan.
The fight is over either when the player is killed, or Heigan is defeated.

Input:
•	On the first line, you receive a floating-point number D – the damage done to Heigan each turn.
•	On the next several lines – you receive input in format "{spell} {row} {col}" – the spell is either Cloud or Eruption.

Output:
    • On the first line
        o	If Heigan is defeated: "Heigan: Defeated!"
        o	Else: "Heigan: {remaining}", where remaining is rounded to two digits after the decimal separator.
    • On the second line:
        o	If the player is killed: "Player: Killed by {spell}".
        o	Else "Player: {remaining}".
    •	    On the third line: "Final position: {row, col}" -> the last coordinates of the player.

Constraints:
•	D is a floating-point number in the range [0 … 500000].
•	A damaging spell will always affect at least one cell.
•	Allowed memory: 250ms/16MB.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] chamber = new String[15][15];
        double playerHP = 18500;
        boolean playerLost = false;
        double playerDmg = Double.parseDouble(scanner.nextLine());
        double bossHP = 3000000;
        boolean playerWon = false;
        int playerX = 7;
        int playerY = 7;
        boolean isCloudActive = false;
        String spell = "";
        String spellData = scanner.nextLine();

        while (true) {

            if (playerHP > 0) {
                bossHP -= playerDmg;
                if (bossHP < 0) {
                    playerWon = true;
                }
            }

            if (isCloudActive) {
                playerHP -= 3500;
                if (playerHP <= 0) {
                    playerLost = true;
                }
                isCloudActive = false;
            }

            if (playerWon || playerLost) {
                break;
            }

            spell = spellData.split(" ")[0];
            int spellX = Integer.parseInt(spellData.split(" ")[1]);
            int spellY = Integer.parseInt(spellData.split(" ")[2]);

            if (playerIsInSpellRange(spellX, spellY, playerX, playerY)) {
                if (!playerIsInSpellRange(spellX, spellY, playerX - 1, playerY) && playerIsInChamber(playerX - 1, playerY, chamber)) {
                    playerX--;
                } else if (!playerIsInSpellRange(spellX, spellY, playerX, playerY + 1) && playerIsInChamber(playerX, playerY + 1, chamber)) {
                    playerY++;
                } else if (!playerIsInSpellRange(spellX, spellY, playerX + 1, playerY) && playerIsInChamber(playerX + 1, playerY, chamber)) {
                    playerX++;
                } else if (!playerIsInSpellRange(spellX, spellY, playerX, playerY - 1) && playerIsInChamber(playerX, playerY - 1, chamber)) {
                    playerY--;
                } else {
                    if (spell.equals("Cloud")) {
                        playerHP -= 3500;
                        isCloudActive = true;
                    } else if (spell.equals("Eruption")) {
                        playerHP -= 6000;
                    }
                    if (playerHP <= 0) {
                        playerLost = true;
                        break;
                    }
                }
            }
            spellData = scanner.nextLine();
        }

        if (playerWon) {
            System.out.println("Heigan: Defeated!");
            if (playerHP <= 0) {
                spell = "Plague Cloud";
                System.out.printf("Player: Killed by %s\n", spell);
            } else {
                System.out.printf("Player: %.0f\n", playerHP);
            }
        } else {
            System.out.printf("Heigan: %.2f\n", bossHP);
            if (spell.equals("Cloud")) {
                spell = "Plague Cloud";
            }
            System.out.printf("Player: Killed by %s\n", spell);
        }
        System.out.printf("Final position: %d, %d\n", playerX, playerY);
    }

    private static boolean playerIsInSpellRange(int spellRangeX, int spellRangeY, int playerPosX, int playerPosY) {
        return (spellRangeX - 1 <= playerPosX && spellRangeX + 1 >= playerPosX) && (spellRangeY - 1 <= playerPosY && spellRangeY + 1 >= playerPosY);
    }

    private static boolean playerIsInChamber(int playerPosX, int playerPosY, String[][] chamber) {
        return playerPosX >= 0 && playerPosX < chamber.length && playerPosY >= 0 && playerPosY < chamber.length;
    }

}