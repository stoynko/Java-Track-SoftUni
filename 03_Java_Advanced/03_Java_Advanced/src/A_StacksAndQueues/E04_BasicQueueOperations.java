package A_StacksAndQueues;

import java.util.*;

public class E04_BasicQueueOperations {

/*You will be given an integer N representing the number of elements to enqueue (add),
an integer S representing the number of elements to dequeue (remove/poll) from the queue, and finally,
an integer X, an element that you should check whether is present in the queue.
If it is - prints true on the console, if it is not - print the smallest element currently present in the queue.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();
        int[] data = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            queue.offer(data[i]);
        }
        for (int i = 0; i < s; i++) {
            if (!queue.isEmpty()) {
                queue.poll();
            }
        }

        if (queue.contains(x)) {
            System.out.println("true");
        } else {
            if (!queue.isEmpty()) {
                System.out.println(Collections.min(queue));
            } else {
                System.out.println("0");
            }
        }
    }
}
