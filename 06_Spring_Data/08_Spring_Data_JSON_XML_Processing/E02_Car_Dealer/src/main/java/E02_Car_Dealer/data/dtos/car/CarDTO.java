package E02_Car_Dealer.data.dtos.car;

import com.fasterxml.jackson.dataformat.xml.annotation.*;

public class CarDTO {

    private String make;

    private String model;

    private Long travelledDistance;

    public CarDTO() { }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }
}
