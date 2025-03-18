package C_Advanced.G_Generics.E02_GenericBoxOfInteger;

import java.util.*;

public class Main {

//Use the description of the previous problem but now, test your generic box with Integers.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> genericBox = new Box<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            genericBox.add(input);
        }
        System.out.println(genericBox);
    }
}

