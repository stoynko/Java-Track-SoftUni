package C_Java_Advanced.F_DefiningClasses.E06_PokemonTrainer;

import java.util.*;
import java.util.stream.*;

public class Main {

/*You want to be the best pokemon trainer, like no one ever was, so you set out to catch pokemon. Define a class Trainer and a class Pokemon. The trainer has a name,
a number of badges, and a collection of pokemon. Pokemon has a name, an element, and health, all values are mandatory. Every Trainer starts with 0 badges.
From the console, you will receive an unknown number of lines until you receive the command "Tournament",
each line will carry information about a pokemon and the trainer who caught it in the format "{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"
where TrainerName is the name of the Trainer who caught the pokemon, names are unique there cannot be 2 trainers with the same name.
After receiving the command "Tournament" an unknown number of lines containing one of three elements "Fire", "Water", and "Electricity" will follow
until the command "End" is received. For every command, you must check if a trainer has at least 1 pokemon with the given element,
if he does he receives 1 badge, otherwise, all his pokemon lose 10 health, if a pokemon falls to 0 or less health, he dies and must be deleted from the trainer's collection.
After the command "End" is received, you should print all trainers sorted by the amount of badges they have in descending order (if two trainers have the same amount of badges,
they should be sorted by order of appearance in the input) in the format "{TrainerName} {Badges} {NumberOfPokemon}".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<Trainer, List<Pokemon>> trainersCollections = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {

            String[] inputData = input.split(" ");
            String trainerName = inputData[0];
            Pokemon currentPokemon = catchPokemon(inputData);
            Trainer trainer = new Trainer(trainerName, Trainer.BADGES_INITIAL_VALUE);
            trainersCollections.putIfAbsent(trainer, new ArrayList<>());
            trainersCollections.get(trainer).add(currentPokemon);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {

            String element = input;

            for (Trainer trainer : trainersCollections.keySet()) {
                if (hasElementPokemon(trainersCollections, trainer, element)) {
                    trainer.setBadgesCount(trainer.getBadgesCount() + 1);
                } else {
                    trainersCollections = decreaseHealth(trainersCollections, trainer);
                }
            }

            input = scanner.nextLine();
        }

        trainersCollections = trainersCollections.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> -entry.getKey().getBadgesCount()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (existing, replacement) -> existing, LinkedHashMap::new));

        trainersCollections.entrySet().forEach(entry -> {
            System.out.printf("%s %d %d\n", entry.getKey().toString(), entry.getKey().getBadgesCount(), entry.getValue().size());
        });
    }

    private static Map<Trainer, List<Pokemon>> decreaseHealth(Map<Trainer, List<Pokemon>> trainers, Trainer trainer) {

        List<Pokemon> pokemons = trainers.get(trainer);

        for (int index = 0; index < pokemons.size(); index++) {

            int health = pokemons.get(index).getHealth();
            pokemons.get(index).setHealth(health - 10);

            if (pokemons.get(index).getHealth() <= 0) {
                pokemons.remove(index);
            }
        }
        return trainers;
    }

    private static boolean hasElementPokemon(Map<Trainer, List<Pokemon>> trainers, Trainer trainer, String element) {
        return trainers.get(trainer).stream().anyMatch(pokemon -> pokemon.getElement().equals(element));
    }

    private static Pokemon catchPokemon(String[] inputData) {
        String pokemonName = inputData[1];
        String pokemonElement = inputData[2];
        int pokemonHealth = Integer.parseInt(inputData[3]);
        return new Pokemon(pokemonName, pokemonElement, pokemonHealth);
    }
}
