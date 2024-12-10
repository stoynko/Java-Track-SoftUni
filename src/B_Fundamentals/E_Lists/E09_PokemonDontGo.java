package B_Fundamentals.E_Lists;

import java.util.*;
import java.util.stream.*;

public class E09_PokemonDontGo {

/*Ely likes to play Pokémon Go a lot. But Pokémon Go went bankrupt… So, the developers made Pokémon Don't Go out of depression.
And so, Ely now plays Pokémon Don't Go. In Pokémon Don't Go, when you walk to a certain Pokémon, those closest to you naturally get further,
and those further from you get closer.

You will receive a sequence of integers, separated by spaces - the distances to the Pokémons.
Then you will begin receiving integers corresponding to indexes in that sequence.

When you receive an index, you must remove the element at that index from the sequence (as if you've captured the Pokémon).
    •	You must INCREASE the value of all elements in the sequence which are LESS or EQUAL to the removed element with the value of the removed element.
    •	You must DECREASE the value of all elements in the sequence which are GREATER than the removed element with the value of the removed element.

If the given index is LESS than 0, remove the first element of the sequence, and COPY the last element to its place.
If the given index is GREATER than the last index of the sequence, remove the last element from the sequence, and COPY the first element to its place.
The increasing and decreasing of elements should be done in these cases, also. The element whose value you should use is the REMOVED element.
The program ends when the sequence has no elements (there are no Pokémons left for Ely to catch).

Input:
    •	On the first line of input, you will receive a sequence of integers, separated by spaces.
    •	On the next several lines, you will receive integers – the indexes.

Output:
    •	When the program ends, you must print the summed up value of all REMOVED elements on the console.

Constraints:
    •	The input data will consist ONLY of valid integers in the range [-2.147.483.648, 2.147.483.647].*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> pokemons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int capturedValue = 0;

        while (!pokemons.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            if (index < 0) {
                int pokemonPower = pokemons.get(0);
                capturedValue += pokemonPower;
                pokemons.set(0, pokemons.get(pokemons.size() - 1));
                modifyPokemons(pokemons, pokemonPower);

            } else if (index > pokemons.size() - 1) {
                int pokemonPower = pokemons.get(pokemons.size() - 1);
                capturedValue += pokemonPower;
                pokemons.set(pokemons.size() - 1, pokemons.get(0));
                modifyPokemons(pokemons, pokemonPower);

            } else {
                int pokemonPower = pokemons.get(index);
                capturedValue += pokemonPower;
                pokemons.remove(index);
                modifyPokemons(pokemons, pokemonPower);
            }
        }
        System.out.println(capturedValue);
    }

    private static void modifyPokemons(List<Integer> pokemons, int pokemonPower) {

        if (pokemons.isEmpty()) {
            return;
        } else {
            for (int position = 0; position < pokemons.size(); position++) {
                int currentPokemonPower = pokemons.get(position);
                if (currentPokemonPower <= pokemonPower) {
                    pokemons.set(position, currentPokemonPower + pokemonPower);
                } else {
                    pokemons.set(position, currentPokemonPower - pokemonPower);
                }
            }
        }
    }
}