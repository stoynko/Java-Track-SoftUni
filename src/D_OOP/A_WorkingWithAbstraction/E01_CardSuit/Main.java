package D_OOP.A_WorkingWithAbstraction.E01_CardSuit;

public class Main {

/*Create an enumeration type that has as its constants the four suits of a deck of playing cards (CLUBS, DIAMONDS, HEARTS, SPADES).
Iterate over the values of the enumeration type and print all ordinal values and names. */

    public static void main(String[] args) {

        System.out.println("Card Suits:");
        for (CardSuit card : CardSuit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", card.ordinal(), card.name());
        }
    }
}
