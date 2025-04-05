package C_Java_Advanced.C_SetsAndDictionariesAdvanced;

import java.util.*;

public class L06_ProductShop {

/*Write a program that prints information about food shops in Sofia and the products they store.
Until the "Revision" command you will receive an input in the format: "{shop}, {product}, {price}".
Keep in mind that if you get a store that already exists, you must gather product information.
Your output must be ordered by shop name and must be in the format:
"{shop}-> Product: {product}, Price: {price}"
The price should be formatted to one digit after the decimal point.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TreeMap<String, ArrayList<String>> shops = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Revision")) {

            String shopName = input.split(",\\s+")[0];
            String product = input.split(",\\s+")[1];
            String price = input.split(",\\s+")[2];

            if (!shops.containsKey(shopName)) { // Няма такъв магазин все още
                shops.put(shopName, new ArrayList<>()); // Създаваме го с лист от артикули
                if (!shops.get(shopName).contains(product)) { // Ако в магазина няма такъв артикул
                    shops.get(shopName).add(product + " " + price);
                }
            } else {
                shops.get(shopName).add(product + " " + price);
        }

        input = scanner.nextLine();
    }

        for (Map.Entry<String, ArrayList<String>> shop : shops.entrySet()) {
            System.out.printf("%s->\n", shop.getKey());
            for (String products : shop.getValue()) {
                System.out.println(products);
                String product = products.split(",\\s+")[0].split(" ")[0];
                Double price = Double.parseDouble(products.split(",\\s+")[0].split(" ")[1]);
                System.out.printf("Product: %s, Price: %.1f\n", product , price);
            }
        }


}
}
