package A_StacksAndQueues;

import java.util.*;

public class L06_HotPotato {

/*Hot potato is a game in which children form a circle and start passing a hot potato. The counting starts with the first kid.
Every nth toss, the child left with the potato leaves the game. When a kid leaves the game, it passes the potato forward.
This continues repeating until there is only one kid left.
Create a program that simulates the game of Hot Potato. Print every kid that is removed from the circle.
In the end, print the kid that is left last.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> participantsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(participantsQueue::offer);
        int tosses = Integer.parseInt(scanner.nextLine());

        while (participantsQueue.size() > 1) {
            for (int currentToss = 1; currentToss < tosses; currentToss++) {
                String participant = participantsQueue.poll();
                participantsQueue.offer(participant);
            }
            String removedParticipant = participantsQueue.poll();
            System.out.printf("Removed %s\n", removedParticipant);
        }
        System.out.printf("Last is %s\n", participantsQueue.poll());
    }
}
