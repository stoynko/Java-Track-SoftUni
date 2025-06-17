package C_SetsAndDictionariesAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class E09_PopulationCounter {

/*So many people! It's hard to count them all. But that's your job as a statistician. You get raw data for a given city,
and you need to aggregate it. On each input line, you'll be given data in the format: "city|country|population".
There will be no redundant whitespaces anywhere in the input. Aggregate the data by country and by city and print it on the console.
For each country, print its total population and on separate lines the data for each of its cities.
Countries should be ordered by their total population in descending order, and within each country,
the cities should be ordered by the same criterion. If two countries/cities have the same population,
keep them in the order in which they were entered. Check out the examples. Follow the output format strictly!

Input:
•	The input data should be read from the console.
•	It consists of a variable number of lines and ends when the command "report" is received.
•	The input data will always be valid and in the format described. There is no need to check it explicitly.

Output:
•	The output should be printed on the console.
•	Print the aggregated data for each country and city in the format shown below.

Constraints:
•	The name of the city, country, and population count will be separated from each other by a pipe ("|").
•	The number of input lines will be in the range [2 … 50].
•	A city-country pair will not be repeated.
•	The population count of each city will be an integer in the range [0 … 2 000 000 000].
•	Time limit: 100ms/16MB.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Long>> populationData = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("report")) {

            String[] inputData = input.split("\\|");
            String city = inputData[0];
            String country = inputData[1];
            long population = Long.parseLong(inputData[2]);

            populationData.putIfAbsent(country, new LinkedHashMap<>());
            populationData.get(country).merge(city, population, Long::sum);

            input = scanner.nextLine();
        }

        List<Map.Entry<String, LinkedHashMap<String, Long>>> sortedCountries = populationData.entrySet().stream()
                .sorted((entryA, entryB) -> {
                    long totalPopulationA = entryA.getValue().values().stream().mapToLong(Long::longValue).sum();
                    long totalPopulationB = entryB.getValue().values().stream().mapToLong(Long::longValue).sum();
                    return Long.compare(totalPopulationB, totalPopulationA);
                })
                .collect(Collectors.toList());


        for (Map.Entry<String, LinkedHashMap<String, Long>> countryEntry : sortedCountries) {
            String country = countryEntry.getKey();
            LinkedHashMap<String, Long> cities = countryEntry.getValue();

            long totalPopulation = cities.values().stream().mapToLong(Long::longValue).sum();
            System.out.printf("%s (total population: %d)%n", country, totalPopulation);

            cities.entrySet().stream()
                    .sorted((cityA, cityB) -> Long.compare(cityB.getValue(), cityA.getValue()))
                    .forEach(cityEntry -> System.out.printf("=>%s: %d%n", cityEntry.getKey(), cityEntry.getValue()));
        }
    }
}