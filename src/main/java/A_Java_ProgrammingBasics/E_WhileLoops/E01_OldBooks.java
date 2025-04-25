package A_Java_ProgrammingBasics.E_WhileLoops;

import java.util.*;

public class E01_OldBooks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String searchingFor = scanner.nextLine();
        String input = scanner.nextLine();
        int counter = 0;

        while (true) {
            if (input.equals("No More Books")) {
                System.out.println("The book you search is not here!");
                System.out.printf("You checked %d books.", counter);
                break;
            }
            if (input.equals(searchingFor)) {
                System.out.printf("You checked %d books and found it.", counter);
                break;
            }
            input = scanner.nextLine();
            counter++;
        }
    }
}