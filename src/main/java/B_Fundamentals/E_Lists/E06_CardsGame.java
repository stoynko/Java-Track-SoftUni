package B_Fundamentals.E_Lists;

import java.util.*;
import java.util.stream.*;

public class E06_CardsGame {

/*You will be given two hands of cards, which will be integer numbers. Assume that you have two players.
You must find the winning deck and, respectively, the winner. You start from the beginning of both hands. Compare the cards from the first deck to those from the second.
The player, who has a bigger card, takes both cards and puts them on the back of his hand - the second player's card is last, and the first person's card
(the winning one) is before it (second to last), and the player with the smaller card must remove the card from his deck.
If both players' cards have the same values - no one wins, and the two cards must be removed from the decks.

The game is over when one of the decks is left without any cards.
You have to print the winner on the console and the sum of the left cards: "{First/Second} player wins! Sum: {sum}".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> deckPlayerA = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> deckPlayerB = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        boolean playerAWins = false;
        boolean playerBWins = false;

        while (true) {
            int cardPlayerA = deckPlayerA.getFirst();
            int cardPlayerB = deckPlayerB.getFirst();

            if (cardPlayerA > cardPlayerB) {
                deckPlayerA.removeFirst();
                deckPlayerA.add(cardPlayerA);
                deckPlayerB.removeFirst();
                deckPlayerA.add(cardPlayerB);
            } else if (cardPlayerB > cardPlayerA) {
                deckPlayerB.removeFirst();
                deckPlayerB.add(cardPlayerB);
                deckPlayerA.removeFirst();
                deckPlayerB.add(cardPlayerA);
            } else {
                deckPlayerA.removeFirst();
                deckPlayerB.removeFirst();
            }

            if (deckPlayerA.isEmpty()) {
                playerBWins = true;
                break;
            } else if (deckPlayerB.isEmpty()) {
                playerAWins = true;
                break;
            }
        }
        int cardsSum = 0;

        if (playerAWins) {
            for (int cardValue : deckPlayerA) {
                cardsSum += cardValue;
            }
            System.out.printf("First player wins! Sum: %d", cardsSum);
        } else if (playerBWins) {
            for (int cardValue : deckPlayerB) {
                cardsSum += cardValue;
            }
            System.out.printf("Second player wins! Sum: %d", cardsSum);
        }
    }
}