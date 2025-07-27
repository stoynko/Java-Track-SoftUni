package E02_Car_Dealer.services.interfaces;

import E02_Car_Dealer.data.dtos.car.*;
import E02_Car_Dealer.data.dtos.car.export.*;
import E02_Car_Dealer.data.dtos.car.input.*;
import jakarta.validation.*;

import java.util.*;

public interface CarService {

    CarDTO importCarData(@Valid ImportCarDTO carDTO, @Valid CarRelationsDTO carRelationsDTO);
    boolean hasBeenImported();
    List<ExportCarDTO> exportCarData();
}
