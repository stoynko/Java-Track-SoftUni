package E01_Products_Shop.service.dtos;

import java.math.*;

public class ExportSoldProductInfoDTO {
    private String name;

    private BigDecimal price;

    public ExportSoldProductInfoDTO() { }

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

