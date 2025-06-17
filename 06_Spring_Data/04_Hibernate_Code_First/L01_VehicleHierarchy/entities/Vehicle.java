package main.java.F_SpringData.D_HibernateCodeFirst.L01_VehicleHierarchy.entities;

import jakarta.persistence.*;

import java.math.*;

@Entity(name = "vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")

public abstract class Vehicle extends IdEntity{

    @Column(insertable = false, updatable = false)
    private String type;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "fuel_type")
    private String fuelType;

    public Vehicle() {}

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
