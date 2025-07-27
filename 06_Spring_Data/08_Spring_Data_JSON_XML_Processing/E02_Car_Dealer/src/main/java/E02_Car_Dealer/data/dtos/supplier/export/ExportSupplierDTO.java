package E02_Car_Dealer.data.dtos.supplier.export;

import com.fasterxml.jackson.dataformat.xml.annotation.*;

import java.util.*;

@JacksonXmlRootElement(localName = "suppliers")
public class ExportSupplierDTO {

    @JacksonXmlProperty(localName = "supplier")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ExportSupplierProductsDTO> suppliersList;

    public ExportSupplierDTO() {
        this.suppliersList = new ArrayList<>();
    }

    public List<ExportSupplierProductsDTO> getSuppliersList() {
        return suppliersList;
    }

    public void setSuppliersList(List<ExportSupplierProductsDTO> suppliersList) {
        this.suppliersList = suppliersList;
    }
}
