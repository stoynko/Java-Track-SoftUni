package E01_Products_Shop.data;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "category", targetEntity = Product.class)
    private Set<Product> products;

    public Category() { }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
