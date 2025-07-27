package E02_Car_Dealer.data.dtos.supplier.export;

import com.fasterxml.jackson.dataformat.xml.annotation.*;

public class ExportSupplierProductsDTO {

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private Long id;

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "parts-count", isAttribute = true)
    private Long partsCount;

    public ExportSupplierProductsDTO(Long id, String name, Long partsCount) {
        this.id = id;
        this.name = name;
        this.partsCount = partsCount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPartsCount() {
        return partsCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartsCount(Long partsCount) {
        this.partsCount = partsCount;
    }
}
