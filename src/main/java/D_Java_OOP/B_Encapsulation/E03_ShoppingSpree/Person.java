package D_Java_OOP.B_Encapsulation.E03_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(this.products);
    }

    public void buyProduct (Product product) {
        if (this.money >= product.getCost()) {
            this.products.add(product);
            setMoney(this.money - product.getCost());
            System.out.printf("%s bought %s\n", this.name, product.getName());
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }
    }
}
