package C_Java_Advanced.C_SetsAndDictionariesAdvanced;

import java.util.*;

public class E06_FixEmails {

/*You are given a sequence of strings, each on a new line, until you receive the "stop" command. The first string is a name of a person.
On the second line, you receive his email. Your task is to collect their names and emails and remove emails whose domain ends with "us", "uk,"
or "com" (case-insensitive). Print in the following format: "{name} – > {email}"*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, String> usersData = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("stop")) {

            String name = input;
            String email = scanner.nextLine();

            if (!usersData.containsKey(name)) {
                if (!(email.endsWith("us") || email.endsWith("uk") || email.endsWith("com"))) {
                    usersData.put(name, email);
                }
            }
            input = scanner.nextLine();
        }

        usersData.forEach((user, email) -> System.out.printf("%s -> %s\n", user, email));
    }
}