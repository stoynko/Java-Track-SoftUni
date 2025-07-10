package E01_Products_Shop.service;

import java.math.*;

public interface ProductService {

    void importDataWithJackson();
    void importDataWithGSON();
    boolean isImported();
    void exportProductsInRange(BigDecimal lowerBound, BigDecimal upperBound);
}
