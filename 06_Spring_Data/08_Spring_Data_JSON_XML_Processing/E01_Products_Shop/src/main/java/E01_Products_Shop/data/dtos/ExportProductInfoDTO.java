package E01_Products_Shop.data.dtos;

import java.util.*;

public class ExportProductInfoDTO {

    private long count;

    private List<ExportSoldProductInfoDTO> products;

    public ExportProductInfoDTO() { }

    public void setCount(long count) {
        this.count = count;
    }

    public void setProducts(List<ExportSoldProductInfoDTO> products) {
        this.products = products;
    }

    public long getCount() {
        return count;
    }

    public List<ExportSoldProductInfoDTO> getProducts() {
        return products;
    }
}
