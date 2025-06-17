package E_Lists;

import java.util.*;
import java.util.stream.*;

public class AE03_TakeSkipRope {

/*Write a program that reads a string and skips through it, extracting a hidden message. The algorithm you have to implement is as follows:

Let's take the string "skipTest_String044170" as an example.
Take every digit from the string and store it somewhere. After that, remove all the digits from the string.
After this operation, you should have two lists of items: the numbers list and the non-numbers list:
    •	Numbers list: [0, 4, 4, 1, 7, 0]
    •	Non-numbers: [s, k, i, p, T, e, s, t, _, S, t, r, i, n, g]
After that, take every digit in the numbers list and split it up into a take list and a skip list, depending on whether the digit is in an even or an odd index:
    •	Numbers list: [0, 4, 4, 1, 7, 0]
    •	Take list: [0, 4, 7]
    •	Skip list: [4, 1, 0]
Afterward, iterate over both of the lists and skip {skipCount} characters from the non-numbers list, then take {takeCount} characters and store it in a result string.
Note that the skipped characters are summed up as they go. The process would look like this on the aforementioned non-numbers list:
Example: "skipTest_String"
    1.	Take 0 characters -> Taken: "", skip 4 characters  Skipped: "skip" -> Result: ""
    2.	Take 4 characters -> Taken: "Test", skip 1 characters  Skipped: "_" -> Result: "Test"
    3.	Take 7 characters -> Taken: "String", skip 0 characters  Skipped: "" -> Result: "TestString"

After that, just print the result string on the console.

Constraints:
    •	The count of digits in the input string will always be even.
    •	The encrypted message will contain any printable ASCII character.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        List<String> input = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        List<Integer> integers = checkForIntegersAndStore(input);
        List<Integer> takeList = splitByEvenIndex(integers);
        List<Integer> skipList = splitByOddIndex(integers);
        boolean take = true;
        boolean skip = false;

        while (!takeList.isEmpty() || !skipList.isEmpty()) {
            int elementsToModify;
            if (take) {
                take = false;
                elementsToModify = takeList.get(0);
                takeList.remove(0);
                if (elementsToModify == 0) {
                    continue;
                } else if (elementsToModify > input.size()) {
                    elementsToModify = input.size();
                }
                output.append(modifyOutput(input, takeList, elementsToModify));
            } else {
                take = true;
                elementsToModify = skipList.get(0);
                skipList.remove(0);
                if (elementsToModify == 0) {
                    continue;
                } else if (elementsToModify > input.size()) {
                    elementsToModify = input.size();
                }
                for (int iteration = 1; iteration <= elementsToModify; iteration++) {
                    input.remove(0);
                }
            }
        }
        System.out.println(output);
    }

    private static StringBuilder modifyOutput(List<String> input, List<Integer> takeList, int elementsToModify) {
        StringBuilder output = new StringBuilder();
        while (elementsToModify > 0) {
            output.append(input.get(0));
            input.remove(0);
            elementsToModify--;
        }
        return output;
    }

    private static List<Integer> checkForIntegersAndStore(List<String> input) {
        List<Integer> integersList = new ArrayList<>();
        for (int index = input.size() - 1; index >= 0; index--) {
            String currentElementString = input.get(index);
            char currentElement = currentElementString.charAt(0);
            int ASCIIcode = (int) currentElement;
            if (ASCIIcode >= 48 && ASCIIcode <= 57) {
                integersList.add(0, Integer.parseInt(input.get(index)));
                input.remove(index);
            }
        }
        return integersList;
    }

    private static List<Integer> splitByEvenIndex(List<Integer> list) {
        List<Integer> integersAtEvenIndex = new ArrayList<>();
        for (int index = 0; index <= list.size() - 1; index += 2) {
            integersAtEvenIndex.add(list.get(index));
        }
        return integersAtEvenIndex;
    }

    private static List<Integer> splitByOddIndex(List<Integer> list) {
        List<Integer> integersAtOddIndex = new ArrayList<>();
        for (int index = 1; index <= list.size() - 1; index += 2) {
            integersAtOddIndex.add(list.get(index));
        }
        return integersAtOddIndex;
    }
}
