package C_Advanced.Y_ExamPreparation.ExamPrep_08;

import java.util.*;
import java.util.stream.*;

public class E01_OffroadChallenge {

/*John is quite an avid off-road fan. He bought a new jeep and made the necessary improvements to it. John is ready for new off-road adventures and can't wait to get started.
In this challenge, he must save his fuel very carefully… There will be two sequences of integers. The first sequence will represent the initial fuel and the second -
additional consumption index due to thin air at high altitudes, hence higher fuel consumption. There will also be a third sequence of integers,
representing values equal to the necessary amount of fuel needed to reach the corresponding altitude in the challenge.

Your task is to take the last fuel quantity from the fuel sequence and the first index from the additional consumption index sequence. Subtract the values and check the result.
    •	The corresponding altitude is reached if the calculated result is bigger or equal to the first element from the needed amount of fuel sequence.
You need to remove both the fuel and the consumption index from their sequences as well as the needed amount of fuel index from their sequence.
    •	If the calculated result is smaller or not equal to the first element from the needed amount of fuel sequence, the corresponding altitude is not reached,
movement cannot continue, and the program should end.

Input:
    •	The first line will represent the initial fuel – integers, separated by a single space.
    •	The second line will represent the consumption indexes that decrease initial fuel – integers, separated by a single space.
    •	The third line will represent the quantities needed to reach the corresponding altitude – integers, separated by a single space.
Output:
    •	On the first or the next n lines, output the corresponding message on the console from the following options:
        o	If John reaches the altitude, print the message: "John has reached: Altitude {n}"
        o	If John fails to reach the altitude, print the message: "John did not reach: Altitude {n}"
    •	On the next lines, based on whether he reached the top or not, print the following on the console in the specified format:
        o	If John doesn't have enough fuel to reach the top but has reached some altitude, display the following messages:
            o	"John failed to reach the top.
            o	Reached altitudes: Altitude 1, … Altitude {n}"
        o	If John does not have enough fuel to reach the top and has not reached any altitude, print:
            o  "John failed to reach the top.
            o	John didn't reach any altitude."
        o	If John manages to reach all the altitudes, he will reach the top. End the program and print on the console the following message:
            o	"John has reached all the altitudes and managed to reach the top!"
Constraints
    •	All the given numbers will be valid integers in the range [1, 200].
    •	All sequences always consist of four elements.
    •	There will be no negative input. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> fuelStack = new ArrayDeque<>();
        ArrayDeque<Integer> consumptionIndex = new ArrayDeque<>();
        List<Integer> altitudeValues = new ArrayList<>();
        List<String> reachedAltitudes = new ArrayList<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(fuelStack::push);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(consumptionIndex::offer);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach((altitudeValues::add));
        boolean hasFailed = false;
        int counter = 1;
        while (!fuelStack.isEmpty() && !consumptionIndex.isEmpty() && !altitudeValues.isEmpty() && !hasFailed) {

            int fuelQuantity = fuelStack.pop();
            int consumption = consumptionIndex.poll();
            int altitude = altitudeValues.get(0);

            int index = 0;
            if (fuelQuantity - consumption >= altitude) {
                altitudeValues.remove(0);
                reachedAltitudes.add(String.format("Altitude %d", counter));
                System.out.printf("John has reached: Altitude %d\n", counter);
            } else {
                System.out.printf("John did not reach: Altitude %d\n", counter);
                hasFailed = true;
            }
            counter++;
        }

        if (reachedAltitudes.size() == 4) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else if (!reachedAltitudes.isEmpty()) {
            System.out.println("John failed to reach the top.");
            System.out.printf("Reached altitudes: %s", String.join(", ", reachedAltitudes));
        } else {
            System.out.println("John failed to reach the top.");
            System.out.println("John didn't reach any altitude.");
        }
    }
}
