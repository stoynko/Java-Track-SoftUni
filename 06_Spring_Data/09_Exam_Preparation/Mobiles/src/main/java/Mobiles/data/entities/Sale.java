package Mobiles.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;

import java.sql.*;
import java.time.*;

@Entity(name = "sales")
public class Sale extends BaseEntity {

    @Column(name = "discounted")
    private Boolean discounted;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @Column(name = "sale_date", nullable = false)
    private LocalDateTime saleDate;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    public Sale() { }

    public void setDiscounted(Boolean discounted) {
        this.discounted = discounted;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Boolean getDiscounted() {
        return discounted;
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public Seller getSeller() {
        return seller;
    }
}
