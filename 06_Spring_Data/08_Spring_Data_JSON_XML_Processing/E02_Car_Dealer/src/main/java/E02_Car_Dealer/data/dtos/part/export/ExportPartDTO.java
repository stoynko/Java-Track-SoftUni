package E02_Car_Dealer.data.dtos.part.export;

import com.fasterxml.jackson.dataformat.xml.annotation.*;

import java.math.*;

public class ExportPartDTO {

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "price", isAttribute = true)
    private BigDecimal price;

    public ExportPartDTO() { }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
