package B_DataTypesAndVariables;

import java.util.*;

public class E04_SumOfChars {

/*Write a program that sums the ASCII codes of n characters. Print the sum on the console.

Input:
•	On the first line, you will receive n – the number of lines that follow.
•	On the next n lines – you will receive letters from the Latin alphabet.

Print the total sum in the following format: "The sum equals: {totalSum}"

Constraints:
•	n will be in the interval [1…20].
•	The characters will always be either upper or lower-case letters from the English alphabet.
•	You will always receive one letter per line.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte n = Byte.parseByte(scanner.nextLine());

        short sum = 0;

        for (int i = 1; i <= n; i++) {
            char character = scanner.nextLine().charAt(0);
            short ASCII = (short) character;
            sum += ASCII;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}