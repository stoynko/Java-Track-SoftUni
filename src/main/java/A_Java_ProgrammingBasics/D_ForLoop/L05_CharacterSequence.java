package A_Java_ProgrammingBasics.D_ForLoop;

import java.util.*;

public class L05_CharacterSequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            System.out.println(letter);
        }
    }
}