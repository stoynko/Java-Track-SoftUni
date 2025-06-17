package Y_FinalExam.FinalExam;

import java.util.*;

public class P01_Hogwarts {

/*Welcome, wizard. We have been waiting for you here, in Hogwarts. Get ready to learn a lot of new potions and spells to fight The one who shall not be named. Your first class is Spellcasting.
First, you will receive a spell that needs to be deciphered. Next, you will be receiving commands split by a single space until you get the "Abracadabra" command. There are 5 possible commands:
    •	"Abjuration"
        o	Replace all letters with upper case and print the result.
    •	"Necromancy"
        o	Replace all letters with lower case and print the result.
    •	"Illusion {index} {letter}"
        o	Replace the letter at the index with the given one and print "Done!"
        o	If the index is invalid, print: "The spell was too weak."
    •	"Divination {first substring} {second substring}"
        o	Replace the first substring (all matches) with the second and print the result.
                o	If the substring does not exist, skip the command.
    •	"Alteration {substring}"
        o	Remove the substring from the string and print the result.
                o	If the substring does not exist, skip the command.

If the input command is not in the list, print "The spell did not work!".

Input / Constraints:
    •	On the 1st line, you are going to receive the string.
    •	On the next lines, until you receive "Abracadabra", you will be receiving commands.
    •	All commands are case-sensitive.
Output:
    •	Print the output of the commands in the format described above.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String spell = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Abracadabra")) {

            String command = input.split("\\s+")[0];

            switch (command) {
                case "Abjuration" -> {
                    spell = spell.toUpperCase();
                    System.out.println(spell);
                }
                case "Necromancy" -> {
                    spell = spell.toLowerCase();
                    System.out.println(spell);
                }
                case "Illusion" -> {
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    if (index < 0 || index > spell.length() - 1) {
                        System.out.println("The spell was too weak.");
                    } else {
                        String letter = input.split("\\s+")[2];
                        StringBuilder newSpell = new StringBuilder(spell);
                        spell = newSpell.deleteCharAt(index).insert(index, letter).toString();
                        System.out.println("Done!");
                    }
                }
                case "Divination" -> {
                    String substring = input.split("\\s+")[1];
                    while (spell.contains(substring)) {
                        String replacement = input.split("\\s+")[2];
                        spell = spell.replace(substring, replacement);
                        System.out.println(spell);
                    }
                }
                case "Alteration" -> {
                    String substring = input.split("\\s+")[1];
                    if (spell.contains(substring)) {
                        int indexStart = spell.indexOf(substring);
                        int indexEnd = indexStart + substring.length();
                        StringBuilder newSpell = new StringBuilder(spell);
                        spell = newSpell.delete(indexStart, indexEnd).toString();
                        System.out.println(spell);
                    }
                }
                default -> System.out.println("The spell did not work!");
            }
            input = scanner.nextLine();
        }
    }
}