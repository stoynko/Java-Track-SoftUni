package D_Java_OOP.A_WorkingWithAbstraction.E05_JediGalaxy.OOP_Refactoring;

import java.util.*;

public class Main {

/*Peter is Jedi, and so he starts gathering stars to grow stronger.
His galaxy is represented as a two-dimensional array. Every cell in the matrix is a star that has a value.
Peter starts at the given col and row. He can move only on the diagonal from the lowest left to the upper right and adds to his score all
the stars (values) from the cells he passes through. Unfortunately, there is always an Evil power that tries to prevent his success.
Evil power starts at the given row and col and instantly destroys all-stars on the opposite diagonal –
From the lowest right to the upper left. Peter adds the values only of the stars that are not destroyed by the evil power.
You will receive two integers, separated by space, which represent the two-dimensional array - the first being the rows and the second being
the columns. Then, you must fill the two-dimensional array with increasing integers starting from 0, and continuing on every row, like this:
first row: 0, 1, 2… m
second row: n+1, n+2, n+3… n + n.

The input ends when you receive the command "Let the Force be with you".
When that happens, you must print the value of all-stars that Peter has collected successfully.

Input:
    •	On the first line, you will receive the number N, M -> the dimensions of the matrix. You must then fill the matrix according to these dimensions.
    •	On the next several lines you will begin receiving 2 integers separated by a single space, which represent Peter’s row and col. On the next line, you will receive the Evil Power’s coordinates.
    •	There will always be at least 2 lines of input to represent at least 1 path of Peter and the Evil force.
    •	When you receive the command, "Let the Force be with you" the input ends.

Output:
    •	The output is simple. Print the sum of the values from all-stars that Peter has collected.

Constraints:
    •	The dimensions of the matrix will be integers in the range [5, 2000].
    •	The given rows will be valid integers in the range [0, 2000].
    •	The given columns will be valid integers in the range [-231 + 1, 231 - 1]. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Field field = new Field(scanner);
        Galaxy galaxy = new Galaxy(field);
        long starsCollected = 0;

        String command = scanner.nextLine();

        while (!command.equals("Let the Force be with you")) {
            int[] playerPosition = readPosition(command);
            int[] enemyPosition = readPosition(scanner.nextLine());

            galaxy.moveEnemy(enemyPosition);
            starsCollected += galaxy.movePlayer(playerPosition);

            command = scanner.nextLine();
        }

        System.out.println(starsCollected);
   }

    private static int[] readPosition(String input) {
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}