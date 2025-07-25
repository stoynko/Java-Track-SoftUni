package E02_Car_Dealer.data.dtos.supplier.input;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

import java.io.*;

@JacksonXmlRootElement(localName = "supplier")
public class ImportSupplierDTO implements Serializable {

    @JacksonXmlProperty(isAttribute = true, localName = "name")
    private String name;

    @JacksonXmlProperty(isAttribute = true, localName = "is-importer")
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
