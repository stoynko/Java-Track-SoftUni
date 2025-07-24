package E01_Products_Shop.repositories;

import java.math.*;

public class CategoryInfoProjection {

    private String name;

    private Long productsCount;

    private Double averagePrice;

    private BigDecimal totalRevenue;

    public CategoryInfoProjection(String name, Long productsCount, Double averagePrice, BigDecimal totalRevenue) {
        this.name = name;
        this.productsCount = productsCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }

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
