package E01_Products_Shop.service.dtos;

import java.math.*;

public class ImportProductDTO {

    private String name;

    private BigDecimal price;

    public ImportProductDTO() { }

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
