package C_Java_Advanced.A_StacksAndQueues;

import java.util.*;

public class L05_PrinterQueue {

/*The printer queue is a simple way to control the order of files sent to a printer device.
We know that a single printer can be shared between multiple devices. So to preserve the order of the files sent,
we can use a queue. Write a program which takes filenames until the "print" command is received.
Then as output, print the filenames in the order of printing. Some of the tasks may be canceled.
If you receive "cancel" you have to remove the first file to be printed. If there is no current file to be printed,
print "Printer is on standby".*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (!printerQueue.isEmpty()) {
                    System.out.printf("Canceled %s\n", printerQueue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printerQueue.offer(input);
            }
            input = scanner.nextLine();
        }

        for (String task : printerQueue) {
            System.out.println(printerQueue.poll());
        }
    }
}
