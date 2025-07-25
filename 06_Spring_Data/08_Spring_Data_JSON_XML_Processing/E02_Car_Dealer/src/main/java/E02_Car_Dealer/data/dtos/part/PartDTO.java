package E02_Car_Dealer.data.dtos.part;

import E02_Car_Dealer.data.entities.*;
import jakarta.persistence.*;

import java.math.*;
import java.util.*;

public class PartDTO {

    private String name;

    private BigDecimal price;

    private int quantity;

    public PartDTO() { }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
}
