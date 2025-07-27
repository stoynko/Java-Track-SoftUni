package E02_Car_Dealer.data.dtos.car.export;

import com.fasterxml.jackson.dataformat.xml.annotation.*;

import java.util.*;

@JacksonXmlRootElement(localName = "cars")
public class ExportCarsDTO {

    @JacksonXmlProperty(localName = "car")
    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<ExportCarDTO> cars;

    public ExportCarsDTO(List<ExportCarDTO> cars) {
        this.cars = cars;
    }

    public ExportCarsDTO() {
        this.cars = new ArrayList<>();
    }

    public List<ExportCarDTO> getCars() {
        return cars;
    }
}
