package C_Java_Advanced.C_SetsAndDictionariesAdvanced;

import java.util.*;

public class L03_Voina {

/*Write a program that:
        •	Reads 20 numbers for both players, separated with " " (single space).
            o	Every player can hold unique numbers.
Each Round, both players get the top number from their deck. The player with the bigger number gets both numbers
and adds them to the bottom of his sequence.

The game ends after 50 rounds or if any player loses all of his numbers.
    Input:
        •	Numbers – Integer
    Output:
        •	Output must be "First player win!", "Second player win!" or "Draw!".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayerDeck = fillDeck(scanner);
        LinkedHashSet<Integer> secondPlayerDeck = fillDeck(scanner);
        int round = 1;

        while (round != 50) {

            if (firstPlayerDeck.isEmpty()) {
                System.out.println("Second player win!");
                return;
            } else if (secondPlayerDeck.isEmpty()) {
                System.out.println("First player win!");
                return;
            }
            round++;
            int firstPlayerCard = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstPlayerCard);
            int secondPlayerCard = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            } else if (firstPlayerCard < secondPlayerCard) {
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }
        }

        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player win!");
        } else if (firstPlayerDeck.size() < secondPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static LinkedHashSet<Integer> fillDeck(Scanner scanner) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int integer : array) {
            set.add(integer);
        }
        return set;
    }
}