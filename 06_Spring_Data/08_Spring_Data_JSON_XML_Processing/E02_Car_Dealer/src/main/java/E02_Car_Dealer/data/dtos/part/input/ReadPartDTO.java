package E02_Car_Dealer.data.dtos.part.input;

import E02_Car_Dealer.data.entities.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

import java.util.*;

@JacksonXmlRootElement(localName = "parts")
public class ReadPartDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "part")
    private List<ImportPartDTO> partList;

    public ReadPartDTO() { }

    public void setPartList(List<ImportPartDTO> partList) {
        this.partList = partList;
    }

    public List<ImportPartDTO> getPartList() {
        return partList;
    }
}
