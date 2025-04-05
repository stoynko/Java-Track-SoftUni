package B_Java_Fundamentals.I_RegularExpressions;

import java.util.*;
import java.util.regex.*;

public class E04_NetherRealms {

/*A mighty battle is coming. In the stormy nether realms, demons fight against each other for supremacy in a duel from which only one will survive.
Your job, however, is not so exciting. You must sign in all the participants in the nether realm's mighty battle's demon book.
A demon's name contains his health and his damage.
The sum of the ASCII codes of all characters (excluding numbers (0-9), arithmetic symbols ('+', '-', '*', '/') and delimiter dot ('.')) gives a demon's total health.
The sum of all numbers in his name forms his base damage. Note that you should consider the plus '+' and minus '-' signs (e.g., +10 is 10 and -10 is -10).
However, there are some symbols ('*' and '/') that can further alter the base damage by multiplying or dividing it by 2
So, multiplication and division are applied only after all numbers are included in the calculation and the order they appear in the name.

Input:
    •	The input will be read from the console. The input consists of a single line containing all demon names separated by commas and zero or more spaces in the format:
    "{demon name}, {demon name}, … , {demon name}"

Output:
Print all demons, each on a separate line in the format:
    •	"{demon name} - {health points} health, {damage points} damage"

Constraints:
    •	A demon's name will contain at least one character.
    •	A demon's name cannot contain blank spaces ' ' or commas ','.
    •	A floating-point number will always have digits before and after its decimal separator.
    •	The number in a demon's name is considered everything that is a valid integer or floating point number (with a dot '.' used as separator).

For example, all these are valid numbers: '4', '+4', '-4', '3.5', '+3.5', '-3.5'.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] demons = scanner.nextLine().replace(" ", "").split(",");
        StringBuilder demonName = new StringBuilder();

        for (String demon : demons) {
            int health = calculateHealth(demon);
            double damage = calculateDamage(demon);

            for (char symbol : demon.toCharArray()) {
                if (symbol == '*') {
                    damage *= 2;
                } else if (symbol == '/') {
                    damage /= 2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage\n", demon, health, damage);
        }
    }

    private static double calculateDamage(String demon) {
        String regex = "\\-?\\d+\\.?\\d*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(demon);
        double damage = 0;
        while (matcher.find()) {
            damage += Double.parseDouble(matcher.group());
        }
        return damage;
    }

    private static int calculateHealth(String demon) {
        int health = 0;
        for (char symbol : demon.toCharArray()) {
            if (!Character.isDigit(symbol) && symbol != '+' && symbol != '-' && symbol != '*' && symbol != '/' && symbol != '.') {
                health += symbol;
            }
        }
        return health;
    }
}