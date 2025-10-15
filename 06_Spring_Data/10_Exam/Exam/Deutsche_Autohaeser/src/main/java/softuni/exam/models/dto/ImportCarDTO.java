package softuni.exam.models.dto;

import com.google.gson.annotations.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import softuni.exam.models.entity.enums.*;

public class ImportCarDTO {

    @Expose
    @Length(min = 2, max = 30)
    private String brand;

    @Expose
    @Length(min = 2, max = 30)
    private String model;

    @Expose
    @Length(min = 17, max = 17)
    private String VIN;

    @Expose
    @Positive
    private String mileage;

    @Expose
    private CarType carType;

    @Expose
    private Long dealership;

    public ImportCarDTO() { }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setDealership(Long dealership) {
        this.dealership = dealership;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getVIN() {
        return VIN;
    }

    public String getMileage() {
        return mileage;
    }

    public CarType getCarType() {
        return carType;
    }

    public Long getDealership() {
        return dealership;
    }
}
