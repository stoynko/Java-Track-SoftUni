package E01_Products_Shop.service.dtos;

import java.util.*;

public class ExportSellerProductInfoDTO {

    private String firstName;

    private String lastName;

    private Set<ExportSoldProductDTO> soldProducts;

    public ExportSellerProductInfoDTO() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSoldProducts(Set<ExportSoldProductDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<ExportSoldProductDTO> getSoldProducts() {
        return soldProducts;
    }
}
