package Y_FinalExam.FinalExam;

import java.util.*;

public class P03_Dictionary {

/*You are in the library, looking for words to write down in your notebook. Your first task is to store every word with its definition.
You will receive all the words and definitions, separated by " | ", and each word and its definition will be separated by ": ".
Note: you could receive the same word more than once with different definitions - you need to store all of them in your notebook.

Next, you will receive only words, again separated by " | ". These are the words that your teacher will test you on.
In the end, you will receive one command, which will be either "Test" or "Hand Over":
    •	If the command is "Test", you should find each word that your teacher will test you on (if it exists in your notebook) and print all its definitions in the following format:
        "{word}:"
        " -{definition1}"
        " -{definition2}"
        …
        " -{definitionN}"
    •	If the command is "Hand Over", you should print only the words that are in your notebook, without the definitions, separated by a space (" ").

Input:
    •	On the first line, you will receive pairs of words and their definition, separated by " | ". Within each pair, the word is separated from the definition with ": ".
    •	On the second line, you will receive only words, separated by " | ".
    •	On the third line, you will receive a command - either "Test" or "Hand Over".

Output:
    •	Print the appropriate message after the "Test" or "Hand Over" command.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> dictionary = new LinkedHashMap<>();
        String[] wordDefinitions = scanner.nextLine().split("\\|");

        for (String wordDef : wordDefinitions) {
            String word = wordDef.split(":")[0].trim();
            String definition = wordDef.split(":")[1].trim();
            if (!dictionary.containsKey(word)) {
                dictionary.put(word, new ArrayList<>());
                dictionary.get(word).add(definition);
            } else {
                dictionary.get(word).add(definition);
            }
        }

        String[] testWords = scanner.nextLine().split("\\s+\\|\\s+");
        String command = scanner.nextLine();

        switch (command) {
            case "Test" -> {
                for (String testWord : testWords) {
                    if (dictionary.containsKey(testWord)) {
                        System.out.printf("%s:\n", testWord);
                        for (String definition : dictionary.get(testWord)) {
                            System.out.printf(" -%s\n", definition);
                        }
                    }
                }
            }
            case "Hand Over" -> {
                List<String> handOverList = new ArrayList<>();
                dictionary.forEach((word, definitions) -> handOverList.add(word));
                System.out.println(String.join(" ", handOverList));
            }
        }
    }

}
