package Y_ExamPreparation.ExamPrep_07;

import java.util.*;
import java.util.stream.*;

public class E01_RapidCourier {

/*On the first line, you will be given a sequence of integers representing packages that need to be delivered, with the values of their weight.
On the next line, you will be given another sequence of integers representing couriers with their loading capacities.
Until there are packages to deliver and couriers available, the program continues running.
Track the total weight of packages delivered by your couriers.

You need to compare the last package to the first courier:
    •	If the courier can deliver the package (the capacity of the courier is equal to or greater than the weight of the package), he does the delivery:
        o	If the capacity of the courier is greater than the weight of the package, reduce the courier's capacity by twice the package's weight:
            	If the new courier's capacity is positive, the courier moves at the back of the sequence with the updated capacity.
            	If the new capacity is zero or negative, remove the courier.
        o	Аdd the weight of the package to the total delivered weight.
        o	Remove the package from the sequence.
    •	If the courier cannot deliver the package (the capacity of the courier is less than the weight of the package), subtract the courier's capacity from the package's weight
        o	Return the remaining weight to the sequence (on its initial position), and remove the courier.
        o	Add the delivered portion of the package's weight to the total delivered weight.

Input / Constraints:
•	On the first line, you will receive integers representing the weight of the packages to be delivered, separated by a single space.
•	On the second line, you will receive integers representing the capacities of the couriers, separated by a single space.
•	All given numbers will be valid integers in the range [0; 100].

Output:
The output of your program should be printed on the Console, on separate lines, formatted according to the following rules:
    •	At the end of the program, print the weight of the packages delivered:
        o	"Total weight: {total_weight} kg"
    •	If all of the packages are delivered and there are no couriers left:
        o	"Congratulations, all packages were delivered successfully by the couriers today."
    •	If there are packages left but no more couriers available:
        o	"Unfortunately, there are no more available couriers to deliver the following packages: {package1}, {package2}, (…),{packagen}"
        o	Print the packages in their current order
    •	If there are couriers left but there are no more packages to deliver:
        o	"Couriers are still on duty: {couriers1}, {couriers2}, (…),{couriersn} but there are no more packages to deliver."
        o	Print the couriers in their current order */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> packagesStack = new ArrayDeque<>();
        ArrayDeque<Integer> couriersQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(packagesStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(couriersQueue::offer);
        int deliveredWeight = 0;

        while (!packagesStack.isEmpty() && !couriersQueue.isEmpty()) {

            int packageWeight = packagesStack.pop();
            int courierCapacity = couriersQueue.poll();

            if (courierCapacity >= packageWeight) {
                if (courierCapacity > packageWeight) {
                    courierCapacity -= 2 * packageWeight;
                    if (courierCapacity > 0) {
                        couriersQueue.offer(courierCapacity);
                    }
                }
                deliveredWeight += packageWeight;
            } else {
                packageWeight -= courierCapacity;
                packagesStack.push(packageWeight);
                deliveredWeight += courierCapacity;
            }
        }

        System.out.printf("Total weight: %d kg\n", deliveredWeight);
        if (packagesStack.isEmpty() && couriersQueue.isEmpty()) {
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        }
        if (!packagesStack.isEmpty() && couriersQueue.isEmpty()) {
            String remainingPackages = packagesStack.reversed().stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Unfortunately, there are no more available couriers to deliver the following packages: %s\n", remainingPackages);
        }
        if (packagesStack.isEmpty() && !couriersQueue.isEmpty()) {
            String availableCouriers = couriersQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Couriers are still on duty: %s but there are no more packages to deliver.\n", availableCouriers);
        }
    }
}
