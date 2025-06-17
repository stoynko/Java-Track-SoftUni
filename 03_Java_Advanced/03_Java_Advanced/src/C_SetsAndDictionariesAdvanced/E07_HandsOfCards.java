package C_SetsAndDictionariesAdvanced;

import java.util.*;

public class E07_HandsOfCards {

/*You are given a sequence of people and what cards he draws from the deck for every person.
The input will be separate lines in the format: "{personName}: {PT, PT, PT,… PT}"

Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the card and T (S, H, D, C) is the type.
The input ends when a "JOKER" is drawn. The name can contain any ASCII symbol except ":". The input will always be valid, and in the format described,
there is no need to check it. A single person cannot have more than one card with the same power and type. If he draws such a card, he discards it.
The people are playing with multiple decks. Each card has a value that is calculated by the power multiplied by the type.
Powers 2 to 10 have the same value, and J to A is 11 to 14. Types are mapped to multipliers the following way (S -> 4, H-> 3, D -> 2, C -> 1).

Finally, print out the total value each player has in his hand in the format: "{personName}: {value}"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashSet<String>> players = new LinkedHashMap<>();
        HashMap<String, Integer> cardsMap = new LinkedHashMap<>();
        cardsMap.put("C", 1);
        cardsMap.put("D", 2);
        cardsMap.put("H", 3);
        cardsMap.put("S", 4);
        cardsMap.put("J", 11);
        cardsMap.put("Q", 12);
        cardsMap.put("K", 13);
        cardsMap.put("A", 14);
        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {

            String playerName = input.split(":")[0];
            String[] drawnCards = input.split(":")[1].trim().split(", ");

            if (!players.containsKey(playerName)) {
                players.put(playerName, new LinkedHashSet<>());
                fillDeck(players, playerName, drawnCards);
            } else {
                fillDeck(players, playerName, drawnCards);
            }

            input = scanner.nextLine();
        }
        calculateScore(players, cardsMap);
        System.out.println();
    }

    private static void calculateScore(Map<String, LinkedHashSet<String>> playersMap, HashMap<String, Integer> cardsMap) {
        for (Map.Entry<String, LinkedHashSet<String>> player : playersMap.entrySet()) {
            System.out.printf("%s: ", player.getKey());
            int totalValue = 0;
            for (String card : player.getValue()) {
                int power; String type; int typeInt;
                if (card.length() > 2) {
                    power = Integer.parseInt(card.charAt(0) + "" + card.charAt(1));
                    type = String.valueOf(card.charAt(2));
                    typeInt = cardsMap.get(type);
                } else {
                    if (Character.isLetter(card.charAt(0))) {
                        String powerChar = String.valueOf(card.charAt(0));
                        power = cardsMap.get(powerChar);
                    } else {
                        power = Integer.parseInt(String.valueOf(card.charAt(0)));
                    }
                    type = String.valueOf(card.charAt(1));
                    typeInt = cardsMap.get(type);
                }

                totalValue += power * typeInt;
            }
            System.out.print(totalValue);
            System.out.println();
        }
    }


    private static void fillDeck(Map<String, LinkedHashSet<String>> players, String playerName, String[] drawnCards) {
        for (String card : drawnCards) {
            players.get(playerName).add(card);
        }
    }
}