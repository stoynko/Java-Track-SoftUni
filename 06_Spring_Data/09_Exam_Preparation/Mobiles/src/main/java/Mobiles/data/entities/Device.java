package Mobiles.data.entities;

import Mobiles.data.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity(name = "devices")
public class Device extends BaseEntity {

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "device_type")
    @Enumerated(value = EnumType.STRING)
    private DeviceType deviceType;

    @Column(name = "model", nullable = false, unique = true)
    private String model;

    @Column(name = "price") @Positive
    private Double price;

    @Column(name = "storage") @Positive
    private int storage;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    public Device() { }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public String getBrand() {
        return brand;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public String getModel() {
        return model;
    }

    public Double getPrice() {
        return price;
    }

    public int getStorage() {
        return storage;
    }

    public Sale getSale() {
        return sale;
    }
}
