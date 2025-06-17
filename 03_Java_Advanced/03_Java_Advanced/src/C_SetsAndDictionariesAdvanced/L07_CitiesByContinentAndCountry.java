package C_SetsAndDictionariesAdvanced;

import java.util.*;

public class L07_CitiesByContinentAndCountry {

//Write a program to read continents, countries, and their cities put them on a nested map, and print them in the order of their first appearance.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> continentsMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String continent = input.split("\\s+")[0];
            String country = input.split("\\s+")[1];
            String city = input.split("\\s+")[2];

            if (continentsMap.containsKey(continent)) {
                if (continentsMap.get(continent).containsKey(country)) {
                    continentsMap.get(continent).get(country).add(city);
                } else {
                    continentsMap.get(continent).put(country, new ArrayList<>());
                    continentsMap.get(continent).get(country).add(city);
                }
            } else {
                LinkedHashMap<String, List<String>> countriesMap = new LinkedHashMap<>();
                List<String> citiesList = new ArrayList<>();
                citiesList.add(city);
                countriesMap.put(country, citiesList);
                continentsMap.put(continent, countriesMap);
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> continent : continentsMap.entrySet()) {
            System.out.printf("%s:\n", continent.getKey());
            for (Map.Entry<String, List<String>> country : continentsMap.get(continent.getKey()).entrySet()) {
                String cities = String.join(", ", country.getValue());

                System.out.printf("  %s -> %s\n", country.getKey(), cities);
            }
        }
    }
}