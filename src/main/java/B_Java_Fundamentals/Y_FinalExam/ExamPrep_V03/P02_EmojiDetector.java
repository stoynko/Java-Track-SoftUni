package B_Java_Fundamentals.Y_FinalExam.ExamPrep_V03;

import java.util.*;
import java.util.regex.*;

public class P02_EmojiDetector {

/*Your task is to write a program that extracts emojis from a text and find the threshold based on the input.
You have to get your cool threshold. It is obtained by multiplying all the digits found in the input.  The cool threshold could be a huge number, so be mindful. An emoji is valid when:
    •	It is surrounded by 2 characters, either "::" or "**"
    •	It is at least 3 characters long (without the surrounding symbols)
    •	It starts with a capital letter
    •	Continues with lowercase letters only
Examples of valid emojis: ::Joy::, **Banana**, ::Wink::
Examples of invalid emojis: ::Joy**, ::fox:es:, **Monk3ys**, :Snak::Es::

You need to count all valid emojis in the text and calculate their coolness. The coolness of the emoji is determined by summing all the ASCII values of all letters in the emoji.
Examples: ::Joy:: - 306, **Banana** - 577, ::Wink:: - 409

You need to print the result of the cool threshold and, after that take all emojis out of the text, count them and print only the cool ones on the console.
Input:
    •	On the single input, you will receive a piece of string.
Output:
    •	On the first line of the output, print the obtained Cool threshold in the format: "Cool threshold: {coolThresholdSum}"
    •	On the following line, print the count of all emojis found in the text in the format:

        "{countOfAllEmojis} emojis found in the text. The cool ones are:
        {cool emoji 1}
        {cool emoji 2}
        …
        {cool emoji N}"
Constraints: There will always be at least one digit in the text!*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(::([A-Z][a-z]{2,})::)|(\\*\\*([A-Z][a-z]{2,})\\*\\*)";
        String regexDigits = "(?<digit>[0-9])";
        Pattern patternEmojis = Pattern.compile(regex);
        Pattern patternDigits = Pattern.compile(regexDigits);
        Matcher matcherEmoji = patternEmojis.matcher(input);
        Matcher matcherDigits = patternDigits.matcher(input);
        List<String> coolEmojis = new ArrayList<>();
        long coolThreshold = 1L;
        int emojiCounter = 0;

        while (matcherDigits.find()) {
            int digit = Integer.parseInt(matcherDigits.group("digit"));
            coolThreshold *= digit;
        }

        while (matcherEmoji.find()) {

            StringBuilder emoji = new StringBuilder(matcherEmoji.group().replace(":", "").replace("*", ""));
            int emojiCoolness = emoji.chars().sum();
            if (emojiCoolness > coolThreshold) {
                coolEmojis.add(matcherEmoji.group());
            }
            emojiCounter++;
        }
        System.out.printf("Cool threshold: %d\n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:\n", emojiCounter);
        for (String emoji : coolEmojis) {
            System.out.println(emoji);
        }

    }
}
