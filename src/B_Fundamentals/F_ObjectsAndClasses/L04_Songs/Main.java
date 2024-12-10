package B_Fundamentals.F_ObjectsAndClasses.L04_Songs;

import java.util.*;

public class Main {

/*Define a class Song, which holds the following information about songs: Type List, Name, and Time.
On the first line, you will receive the number of songs - N.
On the next N-lines, you will be receiving data in the following format: "{typeList}_{name}_{time}".
On the last line, you will receive "Type List" / "all".
Print only the names of the songs which are from that Type List / All songs.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfSongs = Integer.parseInt(scanner.nextLine());
        List<Songs> songsList = new ArrayList<>();

        for (int currentSong = 0; currentSong < numberOfSongs; currentSong++) {
            String input = scanner.nextLine();
            String[] data = input.split("_");
            String typeList = data[0];
            String name = data[1];
            String time = data[2];
            Songs song = new Songs(typeList, name, time);
            songsList.add(song);
        }
        String input = scanner.nextLine();
        if (input.equals("all")) {
            for (Songs song : songsList) {
                System.out.println(song.getName());
            }
        } else {
            for (Songs song : songsList) {
                if (song.getTypeList().equals(input)) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}