package E01_Products_Shop.data.dtos;

import java.math.*;

public class ExportCategoryInfoDTO {

    private String name;

    private Long productsCount;

    private Double averagePrice;

    private BigDecimal totalRevenue;

    public ExportCategoryInfoDTO() { }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductsCount(Long productsCount) {
        this.productsCount = productsCount;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public String getName() {
        return name;
    }

    public Long getProductsCount() {
        return productsCount;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }
}
