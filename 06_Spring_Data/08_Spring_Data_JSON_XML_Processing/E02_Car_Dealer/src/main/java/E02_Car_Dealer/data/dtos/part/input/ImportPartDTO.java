package E02_Car_Dealer.data.dtos.part.input;

import E02_Car_Dealer.data.entities.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

import java.math.*;
import java.util.*;

@JacksonXmlRootElement(localName = "part")
public class ImportPartDTO {

    @JacksonXmlProperty(isAttribute = true, localName = "name")
    private String name;

    @JacksonXmlProperty(isAttribute = true, localName = "price")
    private BigDecimal price;

    @JacksonXmlProperty(isAttribute = true, localName = "quantity")
    private int quantity;

    public ImportPartDTO() { }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
