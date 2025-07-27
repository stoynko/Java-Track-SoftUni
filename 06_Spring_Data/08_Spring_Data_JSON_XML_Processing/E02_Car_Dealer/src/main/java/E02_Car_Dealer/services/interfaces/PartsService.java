package E02_Car_Dealer.services.interfaces;

import E02_Car_Dealer.data.dtos.part.*;
import E02_Car_Dealer.data.dtos.part.input.*;
import E02_Car_Dealer.data.entities.*;
import jakarta.validation.*;
import org.springframework.validation.annotation.*;

@Validated
public interface PartsService {

    Part getReferenceById(Long id);
    PartDTO importPartData(@Valid ImportPartDTO partDTO, @Valid PartRelationsDTO relationDTO);
    boolean hasBeenImported();
}
