package Mobiles.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.*;

@Entity(name = "sellers")
public class Seller extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false, unique = true)
    private String lastName;

    @Column(name = "personal_number", nullable = false, unique = true)
    private String personalNumber;

    @OneToMany(mappedBy = "seller", targetEntity = Sale.class)
    private List<Sale> sales;

    public Seller() { }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }
}
