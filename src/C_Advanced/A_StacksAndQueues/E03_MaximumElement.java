package C_Advanced.A_StacksAndQueues;

import java.util.*;

public class E03_MaximumElement {

    /*You have an empty sequence, and you will be given N commands. Each command is one of the following types:

        •	"1 X" - Push the element X into the stack.
        •	"2" - Delete the element present at the top of the stack.
        •	"3" - Print the maximum element in the stack.
        Input
        •	The first line of input contains an integer N, where 1 ≤ N ≤ 105.
        •	The next N lines contain commands. All commands will be valid and in the format described.
        •	The element X will be in the range 1 ≤ X ≤ 109.
        •	The type of the command will be in the range 1 ≤ Type ≤ 3.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Byte> stack = new ArrayDeque<>();
        byte numberOfCommands = Byte.parseByte(scanner.nextLine());

        for (byte currentCommand = 1; currentCommand <= numberOfCommands; currentCommand++) {

            String[] commands = scanner.nextLine().split("\\s+");
            String command = commands[0];

            switch (command) {
                case "1" -> stack.push(Byte.parseByte(commands[1]));
                case "2" -> stack.pop();
                case "3" -> System.out.println(Collections.max(stack));
            }
        }
    }
}
