package A_WorkingWithAbstraction.E02_CardRank;

public class Main {

/*Create an enumeration type that has as its constants the thirteen ranks of a deck of playing cards
(ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING).
Iterate over the values of the enumeration type and print all ordinal values and names.*/

    public static void main(String[] args) {

        System.out.println("Card Ranks:");
        for (CardsDeck card : CardsDeck.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", card.ordinal(), card.name());
        }
    }
}
