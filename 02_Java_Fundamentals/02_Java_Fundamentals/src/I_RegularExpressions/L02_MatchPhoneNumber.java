package I_RegularExpressions;

import java.util.*;
import java.util.regex.*;

public class L02_MatchPhoneNumber {

/*Write a regular expression to match a valid phone number from Sofia. After you find all valid phones, print them on the console, separated by a comma and a space ", ".

A valid number has the following characteristics:
    •	It starts with "+359".
    •	Then, it is followed by the area code (always 2).
    •	After that, it's followed by the number itself:
        o	The number consists of 7 digits (separated into two groups of 3 and 4 digits, respectively).
    •	The different parts are separated by either a space or a hyphen ('-').

You can use the following RegEx properties to help with the matching:
    •	Use quantifiers to match a specific number of digits.
    •	Use a capturing group to ensure the delimiter is only one of the allowed characters (space or hyphen) and not a combination of both
        (e.g., +359 2-111 111 has mixed delimiters, it is invalid). Use a group back reference to achieve this.
    •	Add a word boundary at the end of the match to avoid partial matches (the last example is on the right-hand side).
    •	Ensure that before the '+' sign, there is either a space or the beginning of the string.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String regex = "\\+[3][5][9]([ | -])[2]\\1\\d{3}\\1\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scanner.nextLine());
        List<String> matchedPhoneNumbers = new ArrayList<>();

        while (matcher.find()) {
            matchedPhoneNumbers.add(matcher.group());
        }
        System.out.printf(String.join(", ", matchedPhoneNumbers));

    }
}