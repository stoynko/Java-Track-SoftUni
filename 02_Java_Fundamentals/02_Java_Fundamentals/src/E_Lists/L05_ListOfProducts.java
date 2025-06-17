package E_Lists;

import java.util.*;

public class L05_ListOfProducts {

/*Read a number n and n lines of products. Print a numbered list of all the products ordered by name.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int amountProducts = Integer.parseInt(scanner.nextLine());
        List<String> products = new ArrayList<>();

        for (int count = 0; count < amountProducts; count++) {
            products.add(scanner.nextLine());
        }
        products.sort(null);
        int counter = 1;
        for (String product : products) {
            System.out.printf("%d.%s%n", counter, product);
            counter++;
        }
    }
}