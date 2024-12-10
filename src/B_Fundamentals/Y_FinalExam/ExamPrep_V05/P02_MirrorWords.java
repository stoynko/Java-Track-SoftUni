package B_Fundamentals.Y_FinalExam.ExamPrep_V05;

import java.util.*;
import java.util.regex.*;

public class P02_MirrorWords {

/*On the first line of the input, you will be given a text string. To win the competition, you have to find all hidden word pairs, read them, and mark the ones that are mirror images of each other.
First of all, you have to extract the hidden word pairs. Hidden word pairs are:
    •	Surrounded by "@" or "#" (only one of the two) in the following pattern #wordOne##wordTwo# or @wordOne@@wordTwo@
    •	At least 3 characters long each (without the surrounding symbols).
    •	Made up of letters only.

If the second word, spelled backward, is the same as the first word and vice versa (casing matters!), they are a match, and you have to store them somewhere. Examples of mirror words:
#Part##traP# @leveL@@Level@ #sAw##wAs#
    •	If you don`t find any valid pairs, print: "No word pairs found!"
    •	If you find valid pairs print their count: "{valid pairs count} word pairs found!"
    •	If there are no mirror words, print: "No mirror words!"
    •	If there are mirror words print:
        "The mirror words are:
        {wordOne} <=> {wordtwo}, {wordOne} <=> {wordtwo}, … {wordOne} <=> {wordtwo}"

Input / Constraints:
•	You will recive a string.

Output:
•	Print the proper output messages in the proper cases as described in the problem description.
•	If there are pairs of mirror words, print them in the end, each pair separated by ", ".
•	Each pair of mirror word must be printed with " <=> " between the words.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([@|#])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> wordPairs = new ArrayList<>();
        int wordPairsCounter = 0;

        while (matcher.find()) {
            wordPairsCounter++;
            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");
            StringBuilder temp = new StringBuilder(wordTwo);
            temp.reverse();
            if (wordOne.contentEquals(temp)) {
                wordPairs.add(wordOne + " <=> " + wordTwo);
            }
        }
        if (wordPairsCounter != 0) {
            System.out.printf("%d word pairs found!\n", wordPairsCounter);

        } else {
            System.out.println("No word pairs found!");
        }

        if (!wordPairs.isEmpty()) {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", wordPairs));
        } else {
            System.out.println("No mirror words!");
        }
    }
}