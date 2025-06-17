package Y_ExamPreparation.ExamPrep_01;

import java.util.*;

public class E01_ItsChocolateTime {

/*First, you will receive a sequence of doubles, representing the milk quantity for the preparation of single chocolate.
After that, you will be given another sequence of doubles - the cacao powder quantity.
Your task is to mix them so you can prepare the chocolates, listed in the table below with different cacao percentages.

    Chocolate types	    Cacao percentage
    Milk Chocolate	          30
    Dark Chocolate	          50
    Baking Chocolate	      100

To prepare chocolate, you have to take the first milk value and the last cacao powder value. The cacao percentage is calculated by dividing the
cacao powder value by the sum of the milk and cacao powder values. If the result of this operation equals one of the point levels described in the table,
you make the chocolate and remove both milk and cacao powder values. Otherwise, you should remove the cacao powder value, increase the milk value by 10,
then remove it from the first position and add it at the end. You need to stop producing chocolates when you run out of milk or cacao powder values.

Your task is considered done if you make at least three chocolates - one of each type.
Input:
    •	The first line of input will represent the milk values - doubles, separated by a single space.
    •	On the second line, you will be given the cacao powder values - doubles again, separated by a single space.

Output:
    •	On the first line of output - print whether you've succeeded in preparing the chocolates
        o	"It’s a Chocolate Time. All chocolate types are prepared."
        o	"Sorry, but you didn't succeed to prepare all types of chocolates."
    •	In the next few lines, you have to print the chocolates you have made at least once, ordered alphabetically in the format: " # {chocolate type} --> {amount}".

Constraints:
    •	All values will be doubles in the range [0, 200]. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Double> milkQuantityQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoQuantityStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(milkQuantityQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(cacaoQuantityStack::push);
        int milkChocCounter = 0;
        int darkChocCounter = 0;
        int bakingChocCounter = 0;

        while (!milkQuantityQueue.isEmpty() && !cacaoQuantityStack.isEmpty()) {

            double milkValue = milkQuantityQueue.poll();
            double cacaoPowderValue = cacaoQuantityStack.pop();
            double cacaoPercentage = (cacaoPowderValue / (milkValue + cacaoPowderValue) * 100);

            if (cacaoPercentage == 30.0) {
                milkChocCounter++;
            } else if (cacaoPercentage == 50.0) {
                darkChocCounter++;
            } else if (cacaoPercentage == 100.0) {
                bakingChocCounter++;
            } else {
                milkValue += 10;
                milkQuantityQueue.offer(milkValue);
            }
        }

        if (milkChocCounter >= 1 && darkChocCounter >= 1 && bakingChocCounter >= 1) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        if (bakingChocCounter > 0) {
            System.out.printf("# Baking Chocolate --> %d\n", bakingChocCounter);
        }
        if (darkChocCounter > 0) {
            System.out.printf("# Dark Chocolate --> %d\n", darkChocCounter);
        }
        if (milkChocCounter > 0) {
            System.out.printf("# Milk Chocolate --> %d\n", milkChocCounter);
        }
    }
}
