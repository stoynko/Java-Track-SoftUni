package E02_Car_Dealer.services.interfaces;

import E02_Car_Dealer.data.dtos.part.*;
import E02_Car_Dealer.data.dtos.part.input.*;
import jakarta.validation.*;
import org.springframework.validation.annotation.*;

@Validated
public interface PartsService {
    PartDTO importPartData(@Valid ImportPartDTO partDTO, @Valid PartRelationsDTO relationDTO);
    boolean hasBeenImported();
}
