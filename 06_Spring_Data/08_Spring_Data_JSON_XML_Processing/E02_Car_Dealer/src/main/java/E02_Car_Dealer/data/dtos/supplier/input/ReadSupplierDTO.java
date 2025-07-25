package E02_Car_Dealer.data.dtos.supplier.input;

import com.fasterxml.jackson.dataformat.xml.annotation.*;

import java.util.*;

@JacksonXmlRootElement(namespace = "suppliers")
public class ReadSupplierDTO {

    private List<ImportSupplierDTO> suppliers;

    public ReadSupplierDTO() { }

    public void setSuppliers(List<ImportSupplierDTO> suppliers) {
        this.suppliers = suppliers;
    }

    public List<ImportSupplierDTO> getSuppliers() {
        return suppliers;
    }
}
