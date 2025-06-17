package X_MidExam.MidExam;

import java.util.*;
import java.util.stream.*;

public class P02_BooksWorld {

/*A publisher asks you to write a program to see if people's favorite genre has changed to find out if readers' tastes are changing.

On the first line, you will receive the old most favorite genres, separated by " | ".
On the next lines, until you receive "Stop!", you will be receiving commands. The supported commands are:
    •	"Join {genre}":
        o	If the genre is not in the collection, add it at the end of the sequence.
        o	Otherwise, ignore the command.
    •	"Drop {genre}":
        o	If the genre is in the collection, remove it from the sequence.
        o	Otherwise, ignore the command.
    •	"Replace {old genre} {new genre}":
        o	If the old genre is in the collection and the new genre is not, replace the old genre with the new one.
        o	Otherwise, ignore the command.
    •	"Prefer {genreIndex1} {genreIndex2}":
        o	If both genre indexes exist in your list, take the two genres and change their places.
        o	Otherwise, skip the command.

You should print the names of the favorite genres in the final collection on a single line, separated by space.

Input / Constraints:

•	On the first line, you will receive the old genres, separated by " | " – string.
•	On the following lines, until the command "Stop!", you will be receiving commands.
•	All the commands will be valid.

Output:
•	Print the names of the favorite genres in the final collection on a single line, separated by space.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> genreList = Arrays.stream(scanner.nextLine().split(" \\| ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Stop!")) {

            String[] commands = input.split(" ");
            String command = commands[0];

            switch (command) {
                case "Join" -> {
                    String genre = commands[1];
                    if (!genreList.contains(genre)) {
                        genreList.add(genre);
                    }
                }
                case "Drop" -> {
                    String genre = commands[1];
                    if (genreList.contains(genre)) {
                        genreList.remove(genre);
                    }
                }
                case "Replace" -> {
                    String oldGenre = commands[1];
                    String newGenre = commands[2];
                    if (genreList.contains(oldGenre) && !genreList.contains(newGenre)) {
                        int oldGenreIndex = genreList.indexOf(oldGenre);
                        genreList.set(oldGenreIndex, newGenre);
                    }
                }
                case "Prefer" -> {
                    int oldGenreIndex = Integer.parseInt(commands[1]);
                    int newGenreIndex = Integer.parseInt(commands[2]);
                    if (oldGenreIndex >= 0 && oldGenreIndex < genreList.size()) {
                        if (newGenreIndex >= 0 && newGenreIndex < genreList.size()) {
                            String oldGenre = genreList.get(oldGenreIndex);
                            String newGenre = genreList.get(newGenreIndex);
                            genreList.set(oldGenreIndex, newGenre);
                            genreList.set(newGenreIndex, oldGenre);
                        }
                    }

                }
            }
            input = scanner.nextLine();
        }
        System.out.println(genreList.toString().replaceAll("[\\[\\],]", ""));
    }
}