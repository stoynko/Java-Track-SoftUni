package E02_Car_Dealer.services.interfaces;

import E02_Car_Dealer.data.dtos.supplier.*;
import E02_Car_Dealer.data.dtos.supplier.input.*;
import jakarta.validation.*;
import org.springframework.validation.annotation.*;

@Validated
public interface SupplierService {

    SupplierDTO importData (@Valid ImportSupplierDTO supplierDTO);
}
