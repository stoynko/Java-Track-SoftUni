package B_Fundamentals.G_AssociativeArraysAndStreamAPI;

import java.util.*;

public class AE01_Ranking {

/*Here comes the final and the most interesting part - the Final ranking of the candidate interns.
 The final ranking is determined by the points of the interview tasks and from the exams in SoftUni.
 Here is your final task.  You will receive some lines of input in the format "{contest}:{password for contest}" until you receive "end of contests".
 Save that data because you will need it later.  After that, you will receive another type of input in the format:

  "{contest}=>{password}=>{username}=>{points}" until you receive "end of submissions".

 Here is what you need to do:
    •	Check if the contest is valid (if you received it in the first type of input);
    •	Check if the password is correct for the given contest;
    •	Save the user with the contest they take part in (a user can take part in many contests) and the points the user has in the given contest.
    If you receive the same contest and the same user, update the points only if the new ones are more than the older ones.
 In the end, you have to print the info for the user with the most points in the format "Best candidate is {user} with total {total points} points.".
 After that, print all students ordered by their names. For each user, print each contest with the points in descending order. See the examples.
 Input:
    •	Strings in format "{contest}:{password for contest}" until the "end of contests" command. There will be no case with two equal contests.
    •	Strings in format "{contest}=>{password}=>{username}=>{points}" until the "end of submissions" command.
    •	There will be no case with 2 or more users with the same total points!
 Output:
    •	On the first line, print the best user in a format:
        "Best candidate is {user} with total {total points} points.".
    •	Then print all students ordered as mentioned above in format:
        "{user1 name}
        #  {contest1} -> {points}
        #  {contest2} -> {points}"
 Constraints:
    •	The strings may contain any ASCII character except (:, =, >).
    •	The numbers will be in the range [0 - 10000].
    •	The second input is always valid.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, String> passwordMap = new HashMap<>();
        TreeMap<String, Map<String, Integer>> usersResults = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end of contests")) {
            String contestName = input.split(":")[0];
            String password = input.split(":")[1];
            passwordMap.putIfAbsent(contestName, password);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("end of submissions")) {
            String[] data = input.split("=>");
            String contestName = data[0];
            String password = data[1];
            String username = data[2];
            int points = Integer.parseInt(data[3]);

            if (passwordMap.containsKey(contestName) && passwordMap.get(contestName).equals(password)) {
                usersResults.putIfAbsent(username, new TreeMap<>());
                Map<String, Integer> contests = usersResults.get(username);
                if (contests.containsKey(contestName)) {
                    contests.put(contestName, Math.max(contests.get(contestName), points));
                } else {
                    contests.put(contestName, points);
                }

            }
            input = scanner.nextLine();
        }

        int maxPoints = 0;
        String bestCandidate = null;
        for (Map.Entry<String, Map<String, Integer>> entry : usersResults.entrySet()) {
            String username = entry.getKey();
            int totalPoints = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
            if (totalPoints > maxPoints) {
                maxPoints = totalPoints;
                bestCandidate = entry.getKey();
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, maxPoints);
        System.out.println("Ranking: ");
        usersResults.forEach((username, results) -> {
            System.out.printf("%s%n", username);
            usersResults.get(username).entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(contest -> System.out.printf("#  %s -> %d%n", contest.getKey(), contest.getValue()));
        });
    }
}