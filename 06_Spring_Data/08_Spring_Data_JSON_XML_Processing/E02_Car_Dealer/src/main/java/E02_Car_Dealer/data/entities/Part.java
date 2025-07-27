package E02_Car_Dealer.data.entities;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.*;

import java.math.*;
import java.util.*;

@Entity(name = "parts")
public class Part extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    @Min(value = 0, message = "Price cannot be negative.")
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @ManyToMany(mappedBy = "partsList", targetEntity = Car.class)
    private List<Car> cars;

    public Part() {
        this.cars = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}
