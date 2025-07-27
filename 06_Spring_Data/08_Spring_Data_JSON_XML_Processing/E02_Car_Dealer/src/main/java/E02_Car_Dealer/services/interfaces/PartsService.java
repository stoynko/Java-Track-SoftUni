package E02_Car_Dealer.services.interfaces;

import E02_Car_Dealer.data.dtos.part.*;
import E02_Car_Dealer.data.dtos.part.input.*;
import jakarta.validation.*;

public interface PartsService {
    PartDTO importPart (@Valid ImportPartDTO partDTO);
    boolean hasBeenImported();
}
