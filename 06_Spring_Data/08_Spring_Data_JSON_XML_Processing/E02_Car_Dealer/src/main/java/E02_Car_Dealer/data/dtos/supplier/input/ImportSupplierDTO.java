package E02_Car_Dealer.data.dtos.supplier.input;

import com.fasterxml.jackson.dataformat.xml.annotation.*;


public class ImportSupplierDTO {

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlProperty(isAttribute = true)
    private Boolean isImporter;

    public ImportSupplierDTO() { }

    public void setName(String name) {
        this.name = name;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }

    public String getName() {
        return name;
    }

    public Boolean getImporter() {
        return isImporter;
    }
}
