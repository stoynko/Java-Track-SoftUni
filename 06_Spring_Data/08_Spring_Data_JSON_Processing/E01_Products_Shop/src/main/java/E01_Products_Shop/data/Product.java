package E01_Products_Shop.data;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.*;

import java.math.*;

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
    private long selledID;

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

    public void setSelledID(long selledID) {
        this.selledID = selledID;
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

    public long getSelledID() {
        return selledID;
    }
}

