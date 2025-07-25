package E02_Car_Dealer.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity(name = "sales")
public class Sale extends BaseEntity {

    private Double discount;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    public Sale() { }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getDiscount() {
        return discount;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }
}
