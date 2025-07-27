package E02_Car_Dealer.services.interfaces;

import E02_Car_Dealer.data.dtos.supplier.*;
import E02_Car_Dealer.data.dtos.supplier.input.*;
import E02_Car_Dealer.data.entities.*;
import jakarta.validation.*;
import org.springframework.validation.annotation.*;

@Validated
public interface SupplierService {

    Supplier getReferenceById(Long id);
    SupplierDTO importData (@Valid ImportSupplierDTO supplierDTO);
    boolean hasBeenImported();
}
