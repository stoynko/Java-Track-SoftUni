package E01_Products_Shop.data;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Basic
    @Length(min = 3)
    private String name;

    @Basic
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private User seller;

    @ManyToMany
    @JoinTable(name = "categories_products",
    joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> category;

    public Product() { }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public User getBuyer() {
        return buyer;
    }

    public User getSeller() {
        return seller;
    }
}

