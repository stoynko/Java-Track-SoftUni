package C_Advanced.Y_ExamPreparation.ExamPrep_04;

import java.util.*;

public class E01_FoodFinder {

/*You will be given two sequences of characters, representing vowels and consonants. Your task is to start checking if the following words could be created:
    •	"pear"
    •	"flour"
    •	"pork"
    •	"olive"
Start by taking the first character of the vowels collection and the last character from the consonant's collection. Then check if these letters are present in one or more
of the given words. If these letters are present, you should store the information. Then process to the next couple of letters until there are no more consonant letters left.
A letter (vowels or consonants) could participate in more than one word, for example:
    •	The letter 'o' is present in  "flour", "pork", and "olive".
    •	The letter 'l' is present in "flour", and "olive".

Keep in mind that:
    •	A vowel letter is always returned to the collection, whether used or not.
    •	A consonant letter is always removed from the collection, whether used or not.

As a result, you should check how many of the given words were found and print:
    "Words found: {numberOfWordsFound}
    {wordOne}
    {wordTwo}
    …"

Input:
    •	On the first line, you will receive characters representing the vowels, separated by a single space (" ").
    •	On the second line, you will receive characters representing the consonants, separated by a single space (" ").
Output:
    •	As a result, print on the first line how many words have been found and on the next N lines, every word:
    "Words found: {numberOfWordsFound}
    {wordOne}
    {wordTwo}
    …"

Print words in the same order as in the problem's description.
Constraints:
    •	All letters will be lowercase.
    •	All letters in the given words are unique.
    •	There will be no case where no word is matched.
    •	The letter 'y' will be always vowel. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"....", ".....", "....", "....."};

        ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> vowelsQueue.offer(e.charAt(0)));

        ArrayDeque<Character> consonantsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> consonantsStack.push(e.charAt(0)));

        while (!consonantsStack.isEmpty()) {

            char vowel = vowelsQueue.poll();
            char consonant = consonantsStack.pop();

            for (int index = 0; index < words.length; index++) {

                String word = words[index];

                int vowelIndex = word.indexOf(vowel);
                if (vowelIndex >= 0) {
                    foundWords[index] = foundWords[index].substring(0, vowelIndex) + vowel + foundWords[index].substring(vowelIndex + 1);
                }
                int consonantIndex = word.indexOf(consonant);
                if (consonantIndex >= 0) {
                    foundWords[index] = foundWords[index].substring(0, consonantIndex) + consonant + foundWords[index].substring(consonantIndex + 1);
                }
            }
            vowelsQueue.offer(vowel);
        }

        List<String> completeWords = Arrays.stream(foundWords).filter(word -> !word.contains(".")).toList();
        System.out.printf("Words found: %d\n", completeWords.size());
        completeWords.forEach(System.out::println);
    }
}
