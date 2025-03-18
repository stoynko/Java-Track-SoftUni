package B_Fundamentals.F_ObjectsAndClasses;

import java.util.*;
import java.util.stream.*;

public class L01_RandomizeWords {

    /*You are given a list of words in one line. Randomize their order and print each word on a separate line.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random randomNumber = new Random();
        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        while (!words.isEmpty()) {
            int randomIndex = randomNumber.nextInt(words.size());
            System.out.println(words.get(randomIndex));
            words.remove(randomIndex);
        }
    }
}