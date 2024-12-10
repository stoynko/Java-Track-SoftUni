package B_Fundamentals.H_TextProcessing;

import java.util.*;

public class E07_StringExplosion {

/*Explosions are marked with ">". Immediately after the mark, there will be an integer,
which signifies the strength of the explosion. You should remove x characters (where x is the strength of the explosion),
starting after the punched character (">"). If you find another explosion mark (">") while you're deleting characters,
you should add strength to your previous explosion. When all characters are processed, print the string without the deleted characters.
You should not delete the explosion character – ">", but you should delete the integers, which represent the strength.

Input:
You will receive a single line with the string.

Output:
Print what is left from the string after explosions.

Constraints:
    •	You will always receive strength for the punches.
    •	The path will consist only of letters from the Latin alphabet, integers, and the char ">".
    •	The strength of the punches will be in the interval [0…9].*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder(scanner.nextLine());

        for (int currentIndex = 0; currentIndex < text.length() - 1; currentIndex++) {

            if (text.charAt(currentIndex) == '>') {
                int explosionIndex = currentIndex + 1;
                int explosionRange = Integer.parseInt(String.valueOf(text.charAt(explosionIndex)));

                while (explosionRange != 0 && explosionIndex <= text.length() - 1) {

                    if (text.charAt(explosionIndex) == '>') {
                        int additionalPower = Integer.parseInt(String.valueOf(text.charAt(explosionIndex + 1)));
                        explosionRange += additionalPower;
                        explosionIndex++;
                        currentIndex++;
                        continue;
                    } else {
                        text.deleteCharAt(explosionIndex);
                    }
                    explosionRange--;
                }
            }
        }
        System.out.println(text);
    }
}