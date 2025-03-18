package D_OOP.B_Encapsulation.E03_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

/*Create two classes: class Person and class Product. Each person should have a name, money, and a bag of products. Each product should have a name and cost.
The name cannot be an empty string. Be careful about white space in the name. Money and cost cannot be a negative number.

Person
    -	name: String
    -	money:  double
    -	products:  List<Product>
    + 	Person (String,  double)
    -	setName (String): void
    -	setMoney (double): void
    +	buyProduct (Product): void
    +	getName(): String

Product
    -	name: String
    -	cost: double
    + 	Product (String,  double)
    -	setCost (double): void
    -	setName (String): void
    +	getName(): String
    +	getCost (): double

Create a program in which each command corresponds to a person buying a product. If the person can afford a product add it to his bag. If a person doesn't have enough money,
throw new llegalArgumentException (class Person, buyProduct() method )with the following message: "{Person name} can't afford {Product name}"

In the first two lines, you are given all people and all products. After all, purchases print every person in the order of appearance and all products that he has bought
also in order of appearance. If nothing is bought, print: "{Person name} - Nothing bought".
Read commands till you find the line with the "END" command.

In case of invalid input throw new llegalArgumentException (class Person, setMoney() method) with message: "Money cannot be negative") or
empty name: throw new llegalArgumentException (class Person,Product setName() method) with message: "	") break the program with an appropriate message */
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*  Peter=11;George=4
            Bread=10;Milk=2  */

        String[] peopleData = scanner.nextLine().split(";");
        String[] productsData = scanner.nextLine().split(";");

        List<Person> people = parsePersonInformation(peopleData);
        List<Product> products = parseProductsInformation(productsData);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] inputData = input.split(" ");
            String personName = inputData[0];
            String product = inputData[1];

            Person currentPerson = people.stream().filter(person -> person.getName().equals(personName)).findFirst().orElse(null);
            Product currentProduct = products.stream().filter(product1 -> product1.getName().equals(product)).findFirst().orElse(null);
            try {
                currentPerson.buyProduct(currentProduct);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
            input = scanner.nextLine();
        }
        System.out.println(printBoughtProducts(people));
    }

    private static String printBoughtProducts (List<Person> people) {

        StringBuilder output = new StringBuilder();

        for (Person person : people) {
            output.append(person.getName() + " - ");
            if (!person.getProducts().isEmpty()) {
                output.append(person.getProducts().stream().map(Product::getName).collect(Collectors.joining(", ")));
            } else {
                output.append("Nothing bought");
            }
            output.append(System.lineSeparator());

        }
        return output.toString();
    }
    private static List<Person> parsePersonInformation(String[] peopleData) {

        List<Person> people = new ArrayList<>();

        for (String person : peopleData) {
            String[] personData = person.split("=");
            String personName = personData[0];
            int personMoney = Integer.parseInt(personData[1]);
            Person currentPerson = new Person(personName, personMoney);
            people.add(currentPerson);
        }

        return people;
    }

    private static List<Product> parseProductsInformation(String[] productsData) {

        List<Product> products = new ArrayList<>();

        for (String product : productsData) {
            String[] productData = product.split("=");
            String productName = productData[0];
            int productCost = Integer.parseInt(productData[1]);
            Product currentProduct = new Product(productName, productCost);
            products.add(currentProduct);
        }

        return products;
    }

}
