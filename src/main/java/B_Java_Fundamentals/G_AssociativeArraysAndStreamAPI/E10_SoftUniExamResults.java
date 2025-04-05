package B_Java_Fundamentals.G_AssociativeArraysAndStreamAPI;

import java.util.*;

public class E10_SoftUniExamResults {

/*Judge statistics on the last Programming Fundamentals exam were not working correctly, so you have the task to take all the submissions and analyze them properly.
You should collect all the submissions and print the final results and statistics about each language in which the participants submitted their solutions.
You will be receiving lines in the following format: "{username}-{language}-{points}" until you receive "exam finished".
You should store each username and their submissions and points. You can receive a command to ban a user for cheating in the following format:
    "{username}-banned".
In that case, you should remove the user from the contest but preserve his submissions in the total count of submissions for each language.
After receiving "exam finished", print each of the participants in the following format:
    "Results:
    {username} | {points}
    {username2} | {points}
    …
    {usernameN} | {points}"

After that, print each language used in the exam in the following format:
    "Submissions:
    {language1} - {submissions_count}
    {language2} - {submissions_count}
    …
    {language3} - {submissions_count}"

Input / Constraints:
    •	Until you receive "exam finished", you will be receiving participant submissions in the following format: "{username}-{language}-{points}"
    •	You can receive a ban command -> "{username}-banned".
    •	The participant's points will always be a valid integer in the range [0-100].
Output:
    •	Print the exam results for each participant.
    •	After that, print each language in the format shown above.
    •	Allowed working time / memory: 100ms / 16MB.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<String, Integer> studentSubmissions = new LinkedHashMap<>();
        HashMap<String, Integer> languageSubmissions = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {

            List<String> data = new ArrayList<>(Arrays.stream(input.split("-")).toList());

            if (data.contains("banned")) {
                String username = data.get(0);
                for (HashMap.Entry<String, Integer> entry : studentSubmissions.entrySet()) {
                    if (entry.getKey().equals(username)) {
                        studentSubmissions.remove(entry.getKey());
                    }
                }
            } else {
                String username = data.get(0);
                String language = data.get(1);
                int points = Integer.parseInt(data.get(2));
                if (!studentSubmissions.containsKey(username)) {
                    studentSubmissions.put(username, points);
                } else {
                    if (points > studentSubmissions.get(username)) {
                        studentSubmissions.put(username, points);
                    }
                }
                if (!languageSubmissions.containsKey(language)) {
                    languageSubmissions.put(language, 1);
                } else {
                    languageSubmissions.put(language, languageSubmissions.get(language) + 1);
                }
            }
            input = scanner.nextLine();
        }

        System.out.println("Results:");
        for (HashMap.Entry<String, Integer> entry : studentSubmissions.entrySet()) {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        }
        System.out.println("Submissions:");
        for (HashMap.Entry<String, Integer> entry : languageSubmissions.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }
}