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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;
        return Objects.equals(getId(), category.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
