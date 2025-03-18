package C_Advanced.H_IteratorsAndComparators.E04_Froggy;

import java.util.*;

public class Main {

/*Let's play a game. You have a tiny little Frog and a Lake with numbers. The Lake and its numbers, you will get by an input from the
console. Imagine, your Frog belongs to the Lake. The Frog jumps only when the "END" command is received. When the Frog starts jumping,
print on the console each number the Frog has stepped over. To calculate the jumps, use the guidelines:

The jumps start from the 0th index. And follows the pattern - first, all even indexes in ascending order(0->2->4->6 and so on)
and then all odd indexes in ascending order (1->3->5->7 and so on). Consider the 0th index as even.

Long story short:
    •	Create a Class Lake, it should implement the interface - Iterable. Inside the Lake, create a Class - Frog and implement the interface Iterator.
        Keep in mind that you will be given integers only.

Input:
    •	The input will consist of two lines. First line - the initial numbers of the lake, separated by a comma and a single space.
        The second line - command is "END".
Output:
    •	When you receive "END", the input is over. Foreach through the collection of numbers the Frog has jumped over and prints each element.
    •	The output should be printed on a single line in the format: "{number}, {second number}, {third number}, …"
Constraints:
    •	C_Advanced.H_IteratorsAndComparators.E04_Froggy.Lake's numbers will be valid integers in the range [2-32…232-1].
    •	The command will always be valid - "END". */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Integer[] elements = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).toArray(Integer[]::new);

        Lake lake = new Lake(elements);
        List<String> output = new ArrayList<>();

        for (Integer element : lake) {
            output.add(String.valueOf(element));
        }

        System.out.println(String.join(", ", output));
    }
}