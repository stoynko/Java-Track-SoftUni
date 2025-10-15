package softuni.exam.models.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.*;

import java.util.*;

public class ImportDealersDTO {

    @JacksonXmlProperty(localName = "dealer")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ImportDealerDTO> dealers;

    public ImportDealersDTO() { }

    public void setDealers(List<ImportDealerDTO> dealers) {
        this.dealers = dealers;
    }

    public List<ImportDealerDTO> getDealers() {
        return dealers;
    }
}
