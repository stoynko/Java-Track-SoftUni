package B_Java_Fundamentals.Y_FinalExam.ExamPrep_V03;

import java.util.*;

public class P03_Pirates {

/*Anno 1681. The Caribbean. The golden age of piracy. You are a well-known pirate captain by the name of Jack Daniels. Together with your comrades Jim (Beam) and Johnny (Walker),
you have been roaming the seas, looking for gold and treasure… and the occasional killing, of course. Go ahead, target some wealthy settlements and show them the pirate's way!

Until the "Sail" command is given, you will be receiving:
    • You and your crew have targeted cities, with their population and gold, separated by "||".
    • If you receive a city that has already been received, you have to increase the population and gold with the given values.
After the "Sail" command, you will start receiving lines of text representing events until the "End" command is given.

Events will be in the following format:
    • "Plunder=>{town}=>{people}=>{gold}"
        o   You have successfully attacked and plundered the town, killing the given number of people and stealing the respective amount of gold.
        o   For every town you attack print this message: "{town} plundered! {gold} gold stolen, {people} citizens killed."
        o   If any of those two values (population or gold) reaches zero, the town is disbanded.
    • You need to remove it from your collection of targeted cities and print the following message: "{town} has been wiped off the map!"
        o   There will be no case of receiving more people or gold than there is in the city.
    • "Prosper=>{town}=>{gold}"
        o   There has been dramatic economic growth in the given city, increasing its treasury by the given amount of gold.
        o   The gold amount can be a negative number, so be careful. If a negative amount of gold is given, print: "Gold added cannot be a negative number!" and ignore the command.
        o   If the given gold is a valid amount, increase the town's gold reserves by the respective amount and print the following message:
        "{gold added} gold added to the city treasury. {town} now has {total gold} gold."
        Input
    • On the first lines, until the "Sail" command, you will be receiving strings representing the cities with their gold and population, separated by "||".
    • On the following lines, until the "End" command, you will be receiving strings representing the actions described above, separated by "=>".
                Output
    • After receiving the "End" command, if there are any existing settlements on your list of targets, you need to print all of them, in the following format:
        "Ahoy, Captain! There are {count} wealthy settlements to go to:
        {town1} -> Population: {people} citizens, Gold: {gold} kg
        {town2} -> Population: {people} citizens, Gold: {gold} kg
        …
        {town…n} -> Population: {people} citizens, Gold: {gold} kg"
    • If there are no settlements left to plunder, print:
        "Ahoy, Captain! All targets have been plundered and destroyed!"
        Constraints
    • The initial population and gold of the settlements will be valid 32-bit integers, never negative, or exceed the respective limits.
    • The town names in the events will always be valid towns that should be on your list.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> citiesPopulation = new LinkedHashMap<>();
        Map<String, Integer> citiesGold = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Sail")) {

            String cityName = input.split("\\|\\|")[0];
            int population = Integer.parseInt(input.split("\\|\\|")[1]);
            int gold = Integer.parseInt(input.split("\\|\\|")[2]);

            citiesPopulation.putIfAbsent(cityName, 0);
            citiesGold.putIfAbsent(cityName, 0);
            citiesPopulation.put(cityName, citiesPopulation.get(cityName) + population);
            citiesGold.put(cityName, citiesGold.get(cityName) + gold);
            input = scanner.nextLine();
        }

        String commandsData = scanner.nextLine();

        while (!commandsData.equals("End")) {

            String command = commandsData.split("=>")[0];
            switch (command) {
                case "Plunder" -> {
                    String cityName = commandsData.split("=>")[1];
                    int population = Integer.parseInt(commandsData.split("=>")[2]);
                    int gold = Integer.parseInt(commandsData.split("=>")[3]);

                    citiesPopulation.put(cityName, citiesPopulation.get(cityName) - population);
                    citiesGold.put(cityName, citiesGold.get(cityName) - gold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", cityName, gold, population);
                    if (citiesPopulation.get(cityName) == 0 || citiesGold.get(cityName) == 0) {
                        citiesPopulation.remove(cityName);
                        citiesGold.remove(cityName);
                        System.out.printf("%s has been wiped off the map!\n", cityName);
                    }
                }
                case "Prosper" -> {
                    String cityName = commandsData.split("=>")[1];
                    int gold = Integer.parseInt(commandsData.split("=>")[2]);
                    if (gold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        citiesGold.put(cityName, citiesGold.get(cityName) + gold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n", gold, cityName, citiesGold.get(cityName));
                    }
                }
            }
            commandsData = scanner.nextLine();
        }
        if (!citiesPopulation.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", citiesPopulation.size());
            citiesPopulation.forEach((cityName, population) -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n", cityName, population, citiesGold.get(cityName)));
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}