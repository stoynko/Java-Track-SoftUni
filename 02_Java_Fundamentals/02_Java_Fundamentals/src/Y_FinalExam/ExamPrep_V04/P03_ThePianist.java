package Y_FinalExam.ExamPrep_V04;

import java.util.*;

public class P03_ThePianist {

/*You are a pianist, and you like to keep a list of your favorite piano pieces. Create a program to help you organize it and add, change, remove pieces from it!
On the first line of the standard input, you will receive an integer n – the number of pieces you will initially have. On the next n lines,
the pieces themselves will follow with their composer and key, separated by "|" in the following format: "{piece}|{composer}|{key}".

Then, you will be receiving different commands, each on a new line, separated by "|", until the "Stop" command is given:
    •	"Add|{piece}|{composer}|{key}":
        o	You need to add the given piece with the information about it to the other pieces and print:
        "{piece} by {composer} in {key} added to the collection!"
        o	If the piece is already in the collection, print:
        "{piece} is already in the collection!"
    •	"Remove|{piece}":
        o	If the piece is in the collection, remove it and print:
        "Successfully removed {piece}!"
        o	Otherwise, print:
        "Invalid operation! {piece} does not exist in the collection."
    •	"ChangeKey|{piece}|{new key}":
        o	If the piece is in the collection, change its key with the given one and print:
        "Changed the key of {piece} to {new key}!"
        o	Otherwise, print:
        "Invalid operation! {piece} does not exist in the collection."
        Upon receiving the "Stop" command, you need to print all pieces in your collection in the following format:
        "{Piece} -> Composer: {composer}, Key: {key}"

Input/Constraints:
    •	You will receive a single integer at first – the initial number of pieces in the collection.
    •	For each piece, you will receive a single line of text with information about it.
    •	Then you will receive multiple commands in the way described above until the command "Stop".

Output:
    •	All the output messages with the appropriate formats are described in the problem description.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> pieces = new LinkedHashMap<>();
        Map<String, String> pieceKeys = new LinkedHashMap<>();
        int numberOfPieces = Integer.parseInt(scanner.nextLine());

        for (int currentPiece = 1; currentPiece <= numberOfPieces; currentPiece++) {
            String pieceData = scanner.nextLine();
            String pieceName = pieceData.split("\\|")[0];
            String composer = pieceData.split("\\|")[1];
            String key = pieceData.split("\\|")[2];
            pieces.put(pieceName, composer);
            pieceKeys.put(pieceName, key);
        }

        String instructions = scanner.nextLine();

        while (!instructions.equals("Stop")) {

            String instruction = instructions.split("\\|")[0];
            switch (instruction) {
                case "Add" -> {
                    String pieceName = instructions.split("\\|")[1];
                    String composer = instructions.split("\\|")[2];
                    String key = instructions.split("\\|")[3];
                    if (!pieces.containsKey(pieceName)) {
                        pieces.put(pieceName, composer);
                        pieceKeys.put(pieceName, key);
                        System.out.printf("%s by %s in %s added to the collection!\n", pieceName, composer, key);
                    } else {
                        System.out.printf("%s is already in the collection!\n", pieceName);
                    }
                }
                case "Remove" -> {
                    String pieceName = instructions.split("\\|")[1];
                    if (pieces.containsKey(pieceName)) {
                        pieces.remove(pieceName);
                        pieceKeys.remove(pieceName);
                        System.out.printf("Successfully removed %s!\n", pieceName);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", pieceName);
                    }
                }
                case "ChangeKey" -> {
                    String pieceName = instructions.split("\\|")[1];
                    String newKey = instructions.split("\\|")[2];
                    if (pieceKeys.containsKey(pieceName)) {
                        pieceKeys.put(pieceName, newKey);
                        System.out.printf("Changed the key of %s to %s!\n", pieceName, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", pieceName);
                    }
                }
            }
            instructions = scanner.nextLine();
        }
        pieces.forEach((pieceName, composer) -> System.out.printf("%s -> Composer: %s, Key: %s\n", pieceName, composer, pieceKeys.get(pieceName)));
    }
}