package D_InterfacesAndAbstraction.L06_Ferrari;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String driverName = scanner.nextLine();
        Ferrari ferrari = new Ferrari(driverName);
        System.out.println(ferrari);
    }
}
