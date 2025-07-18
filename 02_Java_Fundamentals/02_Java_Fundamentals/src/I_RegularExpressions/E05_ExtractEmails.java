package I_RegularExpressions;

import java.util.*;
import java.util.regex.*;

public class E05_ExtractEmails {

/*  Write a program to extract all email addresses from a given text. The text comes at the only input line.
Print the emails on the console, each at a separate line. Emails are considered to be in format <user>@<host>, where:
    •	<user> is a sequence of letters and digits, where '.', '-' and '_' can appear between them.
        o	Examples of valid users: "stephan", "mike03", "s.johnson", "st_steward", "softuni-bulgaria", "12345".
        o	Examples of invalid users: ''--123", ".....", "nakov_-", "_steve", ".info".
    •	<host> is a sequence of at least two words, separated by dots '.'. Each word is a sequence of letters and can have hyphens '-' between the letters.
        o	Examples of hosts: "softuni.bg", "software-university.com", "intoprogramming.info", "mail.softuni.org".
        o	Examples of invalid hosts: "helloworld", ".unknown.soft.", "invalid-host-", "invalid-".
    •	Examples of valid emails: "info@softuni-bulgaria.org", "kiki@hotmail.co.uk", "no-reply@github.com", "s.peterson@mail.uu.net", "info-bg@software-university.software.academy".
    •	Examples of invalid emails: "--123@gmail.com", "…@mail.bg", ".info@info.info", "_steve@yahoo.cn", "mike@helloworld", "mike@.unknown.soft. ", "s.johnson@invalid-".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String regex = "\\b[A-Za-z0-9]+[\\.\\-\\_]?[A-Za-z0-9]+\\@[a-z]+[\\.\\-\\_]?[a-z]+\\.*[a-z]*\\.*[a-z]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scanner.nextLine());

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}