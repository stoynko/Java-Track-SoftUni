package E02_Car_Dealer.data.dtos.car.input;

import com.fasterxml.jackson.dataformat.xml.annotation.*;

import java.util.*;

@JacksonXmlRootElement(localName = "cars")
public class ReadCarDTO {

    @JacksonXmlProperty(localName = "car")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<ImportCarDTO> cars;

    public ReadCarDTO() { }

    public void setCars(List<ImportCarDTO> cars) {
        this.cars = cars;
    }

    public List<ImportCarDTO> getCars() {
        return cars;
    }
}
