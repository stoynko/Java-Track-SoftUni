package C_Java_Advanced.Y_ExamPreparation.ExamPrep_03;

import java.util.*;
import java.util.stream.*;

public class E01_PastryShop {

/*You are asked to cook pastries and cakes for the near pastry shop because your recipes are so great. You need to mix liquids with ingredients to cook the required delicacies.
First, you will be given a sequence of integers, representing liquids. Afterward, you will be given another sequence of integers representing ingredients.
You need to start from the first liquid and try to mix it with the last ingredient. If the sum of their values is equal to any of the items in the table below –
cook the food corresponding to the value and remove both the liquid and the ingredient. Otherwise, remove only the liquid and increase the value of the ingredient by 3.
You need to stop combining when you have no more liquids or ingredients.

    Food	    Value needed
   Biscuit	        25
    Cake	        50
   Pastry	        75
     Pie	        100

Input:
    •	On the first line, you will receive the integers representing the liquids, separated by a single space.
    •	On the second line, you will receive the integers representing the ingredients, separated by a single space.
Output:
    •	On the first line of output print one of the following outputs:
        o	"Great! You succeeded in cooking all the food!" -if you have at least one of each of the foods, after completing combining.
        o	"What a pity! You didn't have enough materials to cook everything." – if you did not collect one of each of the foods, after completing combining.
    •	On the second line - print all liquids you have left:
        o	If there are no liquids: "Liquids left: none"
        o	If there are liquids: "Liquids left: {liquid1}, {liquid2}, {liquid3}, (…)"
    •	On the third line - print all physical materials you have left:
        o	If there are no items: "Ingredients left: none"
        o	If there are items: "Ingredients left: {ingredient}, {ingredient}, {ingredient}, (…)"
    •	Then, you need to print all Advanced Materials and the amount you have of them, ordered:
        o	"Biscuit: {amount}"
        o	"Cake: {amount}"
        o	"Pie: {amount}"
        o	"Pastry: {amount}"

Constraints:
    •	All of the given numbers will be valid integers in the range [0, 100].
    •   Advanced materials can be crafted more than once.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> liquidsInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toList();
        List<Integer> ingredientsInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toList();

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        for (Integer liquid : liquidsInput) {
            liquidsQueue.offer(liquid);
        }
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        for (Integer ingredient : ingredientsInput) {
            ingredientsStack.push(ingredient);
        }
        Map<Integer, String> recipes = new LinkedHashMap<>();
        recipes.put(25, "Biscuit");
        recipes.put(50, "Cake");
        recipes.put(75, "Pastry");
        recipes.put(100, "Pie");
        Map<String, Integer> pastries = new LinkedHashMap<>();
        pastries.put("Biscuit", 0);
        pastries.put("Cake", 0);
        pastries.put("Pie", 0);
        pastries.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int firstLiquid = liquidsQueue.poll();
            int lastIngredient = ingredientsStack.pop();
            int sum = firstLiquid + lastIngredient;

            if (recipes.containsKey(sum)) {
                String pastryCooked = recipes.get(sum);
                pastries.put(pastryCooked, pastries.get(pastryCooked) + 1);
            } else {
                ingredientsStack.push(lastIngredient + 3);
            }
        }

        if (!pastries.containsValue(0)) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (!liquidsQueue.isEmpty()) {
            String liquidsLeft = liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Liquids left: %s\n", liquidsLeft);
        } else {
            System.out.println("Liquids left: none");
        }

        if (!ingredientsStack.isEmpty()) {
            String ingredientsLeft = ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Ingredients left: %s\n", ingredientsLeft);
        } else {
            System.out.println("Ingredients left: none");
        }

        pastries.forEach((pastry, quantity) -> System.out.printf("%s: %d\n", pastry, quantity));

    }
}
