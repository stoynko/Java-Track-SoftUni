package C_Java_Advanced.C_SetsAndDictionariesAdvanced;

import java.util.*;
import java.util.regex.*;

public class E12_SrbskoUnleashed {

/*Admit it – the СРЪБСКО is your favorite sort of music. You never miss a concert, and you have become quite the geek concerning everything involved with СРЪБСКО.
You can't decide between all the singers you know who your favorite one is. One way to find out is to keep a statistic of how much money their concerts make.
Write a program that does all the boring calculations for you. On each input line you’ll be given data in format: "{singer} @{venue} {ticketsPrice} {ticketsCount}".
There will be no redundant whitespaces anywhere in the input. Aggregate the data by venue and by the singer.
For each venue, print the singer and the total amount of money his/her concerts have made on a separate line. Venues should be kept in the same order they were entered,
the singers should be sorted by how much money they have made in descending order. If two singers have made the same amount of money, keep them in the order in which they were entered.
Keep in mind that if a line is in incorrect format, it should be skipped, and its data should not be added to the output. Each of the four tokens must be separated by a space,
everything else is invalid. The venue should be denoted with @ in front of it, such as @Sunny Beach

SKIP THOSE: Ceca@Belgrade125 12378, Ceca @Belgrade12312 123

The singer and town name may consist of one to three words.
    Input:
        •	The input data should be read from the console.
        •	It consists of a variable number of lines and ends when the command "End" is received.
        •	The input data will always be valid and in the format described. There is no need to check it explicitly.
    Output:
        •	The output should be printed on the console.
        •	Print the aggregated data for each venue and singer in the below format.
        •	Format for singer lines is "# {singer} -> {total money}".
    Constraints:
        •	The number of input lines will be in the range [2 … 50].
        •	The ticket price will be an integer in the range [0 … 200].
        •	The ticket count will be an integer in the range [0 … 100 000]
        •	Singers and venues are case-sensitive.
        •	Allowed time:  100ms/16 MB.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> revenuesMap = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            ArrayList<String> inputData = splitInput(input);

            if (!inputData.isEmpty()) {
                String performer = inputData.get(0);
                String venue = inputData.get(1);
                int totalRevenue = Integer.parseInt(inputData.get(2)) * Integer.parseInt(inputData.get(3));

                if (!revenuesMap.containsKey(venue)) {
                    revenuesMap.put(venue, new LinkedHashMap<>());
                    revenuesMap.get(venue).put(performer, totalRevenue);
                } else {
                    if (revenuesMap.get(venue).containsKey(performer)) {
                        revenuesMap.get(venue).put(performer, revenuesMap.get(venue).get(performer) + totalRevenue);
                    } else {
                        revenuesMap.get(venue).put(performer, totalRevenue);
                    }
                }
            }
            input = scanner.nextLine();
        }

        revenuesMap.entrySet().forEach(entry -> {
            System.out.printf("%s\n", entry.getKey());
            entry.getValue().entrySet().stream().sorted((entry1, entry2) -> {
                        int valueCompare = entry2.getValue().compareTo(entry1.getValue());
                        return valueCompare;
                    })
                    .forEach(performer -> System.out.printf("#  %s -> %d\n", performer.getKey(), performer.getValue()));
        });
    }


    private static ArrayList<String> splitInput(String input) {
        String regex = "(?<performer>[A-Za-z]*[ ]?[A-Za-z]*[ ]?[A-Za-z]*[ ]?)[ ][@](?<venue>[A-Za-z]*[ ]?[A-Za-z]*[ ]?[A-Za-z]*)[ ](?<ticketPrice>[0-9]{1,3})[ ](?<ticketsCount>[0-9]{1,6})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        ArrayList<String> inputData = new ArrayList<>();
        if (matcher.find()) {
            inputData.add(matcher.group("performer"));
            inputData.add(matcher.group("venue"));
            inputData.add(matcher.group("ticketPrice"));
            inputData.add(matcher.group("ticketsCount"));
        }
        return inputData;
    }
}
