package B_Fundamentals.I_RegularExpressions;

import java.util.*;
import java.util.regex.*;

public class E03_StarEnigma {

/*The war is at its peak, but you, young Padawan, can turn the tides with your programming skills. You are tasked to create a program to decrypt the messages of The Order and prevent the death of
hundreds of lives. You will receive several messages, which are encrypted using the legendary star enigma. You should decrypt the messages following these rules:

To properly decrypt a message, you should count all the letters [s, t, a, r] – case insensitive and remove the count from the current ASCII value of each symbol of the encrypted message.

After decryption:

Each message should have a planet name, population, attack type ('A', as an attack or 'D', as destruction), and soldier count.
The planet's name starts after '@' and contains only letters from the Latin alphabet.
The planet population starts after ':' and is an Integer;
The attack type may be "A"(attack) or "D"(destruction) and must be surrounded by "!" (Exclamation mark).
The soldier count starts after "->" and should be an Integer.
The order in the message should be: planet name -> planet population -> attack type -> soldier count. Each part can be separated from the others by any character except: '@', '-', '!', ':' and '>'.

Input / Constraints
•	The first line holds n – the number of messages – integer in the range [1…100].
•	On the next n lines, you will be receiving encrypted messages.
Output
•	After decrypting all messages, you should print the decrypted information in the following format:
•	First print the attacked planets, then the destroyed planets.

    "Attacked planets: {attackedPlanetsCount}"
        "-> {planetName}"
        "Destroyed planets: {destroyedPlanetsCount}"
        "-> {planetName}"

The planets should be ordered by name alphabetically.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        int totalMessages = Integer.parseInt(scanner.nextLine());

        for (int currentMessage = 1; currentMessage <= totalMessages; currentMessage++) {

            String decryptedMessage = decryptMessage(scanner.nextLine());
            String regex = "[@](?<planetName>[A-Z][a-z]+)[^@\\-!:>]*[:](?<population>[0-9]+)[^@\\-!:>]*[!](?<attackType>[A]?[D]?)[!][^@\\-!:>]*[-][>](?<soldiersCount>[0-9]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                if (matcher.group("attackType").equals("A")) {
                    attackedPlanets.add(matcher.group("planetName"));
                } else if ((matcher.group("attackType").equals("D"))) {
                    destroyedPlanets.add(matcher.group("planetName"));
                }
            }
        }
        print(attackedPlanets, destroyedPlanets);
    }

    private static void print(List<String> attackedPlanets, List<String> destroyedPlanets) {
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);
        System.out.printf("Attacked planets: %d\n", attackedPlanets.size());
        for (String attackedPlanet : attackedPlanets) {
            System.out.printf("-> %s\n", attackedPlanet);
        }
        System.out.printf("Destroyed planets: %d\n", destroyedPlanets.size());
        for (String destroyedPlanet : destroyedPlanets) {
            System.out.printf("-> %s\n", destroyedPlanet);
        }
    }

    private static String decryptMessage(String encryptedMessage) {

        StringBuilder decryptedMessage = new StringBuilder();
        String decryptionLegend = "STARstar";
        int decryptionKey = 0;

        for (Character c : encryptedMessage.toCharArray()) {
            if (decryptionLegend.contains(String.valueOf(c))) {
                decryptionKey++;
            }
        }

        for (Character c : encryptedMessage.toCharArray()) {
            c = (char) (c - decryptionKey);
            decryptedMessage.append(c);
        }

        return decryptedMessage.toString();
    }
}