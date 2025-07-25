package E02_Car_Dealer.data.dtos.supplier.input;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

import java.io.*;
import java.util.*;

@JacksonXmlRootElement(localName = "suppliers")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReadSupplierDTO implements Serializable {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "supplier")
    private List<ImportSupplierDTO> suppliers;

    public ReadSupplierDTO() { }

    public void setSuppliers(List<ImportSupplierDTO> suppliers) {
        this.suppliers = suppliers;
    }

    public List<ImportSupplierDTO> getSuppliers() {
        return suppliers;
    }
}
