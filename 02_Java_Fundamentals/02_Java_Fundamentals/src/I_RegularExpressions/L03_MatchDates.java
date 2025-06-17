package I_RegularExpressions;

import java.util.*;
import java.util.regex.*;

public class L03_MatchDates {

/*Write a program that matches a date in the format "dd{separator}MMM{separator}yyyy". Use named capturing groups in your regular expression.

Every valid date has the following characteristics:
    •	Always starts with two digits, followed by a separator.
    •	After that, it has one uppercase and two lowercase letters (e.g., Jan, Mar).
    •	After that, it has a separator and exactly 4 digits (for the year).
    •	The separator could be either of three things: a period ("."), a hyphen ("-") or a forward-slash ("/").
    •	The separator needs to be the same for the whole date (e.g., 13.03.2016 is valid, 13.03/2016 is NOT). Use a group back reference to check for this.

Use named capturing groups for the day, month, and year.
Now it's time to find all the valid dates in the input and print each date in the following format: "Day: {day}, Month: {month}, Year: {year}", each on a new line.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String regex = "\\b(?<day>\\d{2})([-./])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scanner.nextLine());

        while (matcher.find()) {
            String day = matcher.group("day");
            String month = matcher.group("month");
            String year = matcher.group("year");
            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        }
    }
}