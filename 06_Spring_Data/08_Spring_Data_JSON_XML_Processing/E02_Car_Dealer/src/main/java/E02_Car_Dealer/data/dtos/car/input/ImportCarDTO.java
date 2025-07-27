package E02_Car_Dealer.data.dtos.car.input;

import com.fasterxml.jackson.dataformat.xml.annotation.*;

public class ImportCarDTO {

    @JacksonXmlProperty(localName = "make")
    private String make;

    @JacksonXmlProperty(localName = "model")
    private String model;

    @JacksonXmlProperty(localName = "travelled-distance")
    private Long travelledDistance;

    public ImportCarDTO() { }

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
