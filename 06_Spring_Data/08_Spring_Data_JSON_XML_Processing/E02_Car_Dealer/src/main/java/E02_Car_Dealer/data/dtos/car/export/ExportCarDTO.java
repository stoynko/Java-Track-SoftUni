package E02_Car_Dealer.data.dtos.car.export;

import E02_Car_Dealer.data.dtos.part.*;
import E02_Car_Dealer.data.dtos.part.export.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

import java.util.*;

@JacksonXmlRootElement(localName = "car")
public class ExportCarDTO {

    @JacksonXmlProperty(localName = "make", isAttribute = true)
    private String make;

    @JacksonXmlProperty(localName = "model", isAttribute = true)
    private String model;

    @JacksonXmlProperty(localName = "travelled-distance", isAttribute = true)
    private Long travelledDistance;

    @JacksonXmlElementWrapper(localName = "parts")
    @JacksonXmlProperty(localName = "part")
    private List<ExportPartDTO> parts;

    public ExportCarDTO() {
        this.parts = new ArrayList<>();
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public void setParts(List<ExportPartDTO> parts) {
        this.parts = parts;
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

    public List<ExportPartDTO> getParts() {
        return parts;
    }
}
