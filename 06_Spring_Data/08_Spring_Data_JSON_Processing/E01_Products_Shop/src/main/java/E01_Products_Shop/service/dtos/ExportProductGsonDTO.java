package E01_Products_Shop.service.dtos;

import java.math.*;

public class ExportProductGsonDTO {

    private String name;

    private BigDecimal price;

    private String sellerNames;

    public ExportProductGsonDTO() { }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSellerNames(String sellerNames) {
        this.sellerNames = sellerNames;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSellerNames() {
        return sellerNames;
    }
}
