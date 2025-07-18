package Y_FinalExam.ExamPrep_V01;

import java.util.*;
import java.util.regex.*;

public class P02_DestinationMapper {

/*Now that you have planned out your tour, you are ready to go! Your next task is to mark all the points on the map that you are going to visit.
You will be given a string representing some places on the map. You have to filter only the valid ones. A valid location is:
    •	Surrounded by "=" or "/" on both sides (the first and the last symbols must match)
    •	After the first "=" or "/" there should be only letters (the first must be upper-case, other letters could be upper or lower-case)
    •	The letters must be at least 3
Example: In the string "=Hawai=/Cyprus/=Invalid/invalid==i5valid=/I5valid/=i=" only the first two locations are valid.

After you have matched all the valid locations, you have to calculate travel points. They are calculated by summing the lengths of all the valid destinations that you have found on the map.
In the end, on the first line, print: "Destinations: {destinations joined by ', '}". On the second line, print "Travel Points: {travel_points}".

Input / Constraints:
    •	You will receive a string representing the locations on the map.
    •	JavaScript: you will receive a single parameter: string.
Output:
    •	Print the messages described above.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([=|\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> destinations = new ArrayList<>();
        int points = 0;

        while (matcher.find()) {
            destinations.add(matcher.group("destination"));
            points += matcher.group("destination").length();
        }

        System.out.printf("Destinations: %s\n", String.join(", ", destinations));
        System.out.printf("Travel Points: %d\n", points);
    }
}