package B_Fundamentals.E_Lists;

import java.util.*;
import java.util.stream.*;

public class AE01_Messaging {

/*You will be given a list of numbers and a string. For each element of the list, you have to take the sum of its digits
and take the element corresponding to that index from the text. If the index is greater than the length of the text,
start counting from the beginning (so that you always have a valid index). After getting the element from the text,
you must remove the character you have taken from it (so for the next index, the text will be with one characterless).*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        List<Integer> integersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> inputList = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());

        for (int number : integersList) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }

            int targetIndex = sum % inputList.size();
            output.append(inputList.remove(targetIndex));
        }

        System.out.println(output.toString());
    }
}
