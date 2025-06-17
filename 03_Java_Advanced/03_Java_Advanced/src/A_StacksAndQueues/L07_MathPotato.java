package A_StacksAndQueues;

import java.util.*;

public class L07_MathPotato {

/*Rework the previous problem by using a PriorityQueue so that a child is removed only on a composite (not prime)
cycle (cycles start from 1). If a cycle is prime, print the child's name.
As before, print the name of the child that is left last.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PriorityQueue<String> participantsQueue = new PriorityQueue<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(participantsQueue::offer);
        int currentToss = 0;

        while (participantsQueue.size() > 1) {
            String participant = participantsQueue.poll();
            currentToss++;

            if (isPrime(currentToss)) {
                System.out.printf("Prime %s\n", participant);
                participantsQueue.offer(participant);
            } else {
                System.out.printf("Removed %s\n", participant);
            }
        }
        System.out.printf("Last is %s\n", participantsQueue.poll());
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i < number ; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}