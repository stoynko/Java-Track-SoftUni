package E01_Products_Shop.data;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.*;

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

    @Column(name = "buyer_id")
    private long buyerID;

    @Column(name = "seller_id")
    private long sellerID;

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

    public void setBuyerID(long buyerID) {
        this.buyerID = buyerID;
    }

    public void setSellerID(long sellerID) {
        this.sellerID = sellerID;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public long getBuyerID() {
        return buyerID;
    }

    public long getSellerID() {
        return sellerID;
    }
}

