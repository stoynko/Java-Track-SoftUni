import entities.*;
import jakarta.persistence.*;

import java.time.*;
import java.util.*;

public class Main {

/* Create a database for storing data about sales using the Code First approach. The database should have the following tables:
    •	product (id, name, quantity, price)
    •	customer (id, name, email, credit_card_number)
    •	store_location (id, location_name)
    •	sale (id, product_id, customer_id, store_location_id, date)

The relationships between the tables are as follows:
    •	Sale has one product and a product can be sold in many sales.
    •	Sale has one customer and a customer can participate in many sales.
    •	Sale has one store location and one store location can have many sales. */

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sales-db");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        List<Product> products = createProducts();
        List<Customer> customers = createCustomers();
        List<StoreLocation> locations = createStoreLocations();
        List<Sale> sales = createSales(products, customers, locations);

        products.forEach(entityManager::persist);
        customers.forEach(entityManager::persist);
        locations.forEach(entityManager::persist);
        sales.forEach(entityManager::persist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Product> createProducts() {
        Product productA = new Product();
        productA.setName("Laptop");
        productA.setPrice(1200);
        productA.setQuantity(10);

        Product productB = new Product();
        productB.setName("Smartphone");
        productB.setPrice(800);
        productB.setQuantity(50);

        Product productC = new Product();
        productC.setName("Headphones");
        productC.setPrice(350);
        productC.setQuantity(30);

        return List.of(productA, productB, productC);
    }

    public static List<Customer> createCustomers() {
        Customer customerA = new Customer();
        customerA.setName("Alice Taylor");
        customerA.setEmail("alice.taylor@email.com");
        customerA.setCreditCardNumber("4532-9100-4567-8910");

        Customer customerB = new Customer();
        customerB.setName("Bob Harrison");
        customerB.setEmail("bob.h@email.com");
        customerB.setCreditCardNumber("5105-1234-5678-9012");

        Customer customerC = new Customer();
        customerC.setName("Carla Johnson");
        customerC.setEmail("carla.j@email.net");
        customerC.setCreditCardNumber("6011-2233-4455-6677");

        return List.of(customerA, customerB, customerC);
    }

    public static List<StoreLocation> createStoreLocations() {
        StoreLocation storeLocationA = new StoreLocation();
        storeLocationA.setLocationName("Downtown Mall");
        StoreLocation storeLocationB = new StoreLocation();
        storeLocationB.setLocationName("Uptown Plaza");
        StoreLocation storeLocationC = new StoreLocation();
        storeLocationC.setLocationName("Tech Hub Center");
        return List.of(storeLocationA, storeLocationB, storeLocationC);
    }

    public static List<Sale> createSales(List<Product> products, List<Customer> customers, List<StoreLocation> locations) {
        Sale saleA = new Sale();
        saleA.setProduct(products.get(0));
        saleA.setCustomer(customers.get(0));
        saleA.setStoreLocation(locations.get(0));
        saleA.setDate(LocalDateTime.of(2024, 6, 1, 10, 15).toInstant(ZoneOffset.UTC));

        Sale saleB = new Sale();
        saleB.setProduct(products.get(1));
        saleB.setCustomer(customers.get(1));
        saleB.setStoreLocation(locations.get(1));
        saleB.setDate(LocalDateTime.of(2024, 8, 13, 13, 30).toInstant(ZoneOffset.UTC));

        Sale saleC = new Sale();
        saleC.setProduct(products.get(2));
        saleC.setCustomer(customers.get(2));
        saleC.setStoreLocation(locations.get(2));
        saleC.setDate(LocalDateTime.of(2024, 12, 21, 14, 55).toInstant(ZoneOffset.UTC));

        return List.of(saleA, saleB, saleC);
    }
}
