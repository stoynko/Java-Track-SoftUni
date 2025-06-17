package H_IteratorsAndComparators.E02_Collection;

import java.util.*;

public class Main {

/*Using the ListyIterator from the last problem, extend it by implementing the Iterable interface,
and implement all methods desired by the interface manually. Add a new method to the class PrintAll(),
the method should foreach the collection and print all elements on a single line separated by a space.

Input:
•	Input will come from the console as lines of commands. The first line will always be the "Create" command in the input
and it will always be the first command passed. The last command received will always be the "END" command.

Output:
•	For every command from the input (with the exception of the "END" and "Create" commands) print the result of that command
on the console, each on a new line. In the case of Move or HasNext commands print the returned value of the method,
in the case of a "Print" command, you don't have to do anything additional as the method itself should already print on the console.
In the case of a "PrintAll" command, you should print all elements on a single line separated by spaces.
Your program should catch any exceptions thrown because of validations and print their messages instead.

Constraints
    •	Do not use the built-in iterators!
    •	The number of commands received will be between [1…100]. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ListyIterator listyIterator = null;

        while (!input.equals("END")) {

            String[] inputData = input.split(" ");
            String command = inputData[0];

            switch (command) {
                case "Create" -> {
                    if (inputData.length > 1) {
                        String[] elements = Arrays.copyOfRange(inputData, 1, inputData.length);
                        listyIterator = new ListyIterator(elements);
                    } else {
                        listyIterator = new ListyIterator();
                    }
                }
                case "Move" -> System.out.println(listyIterator.move());
                case "HasNext" -> System.out.println(listyIterator.hasNext());
                case "Print" -> {
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "PrintAll" -> listyIterator.printAll();
            }

            input = scanner.nextLine();
        }
    }
}