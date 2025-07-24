package E01_Products_Shop.data.dtos;

import java.util.*;

public class ExportSellerInfoDTO {

    private String firstName;

    private String lastName;

    private byte age;

    private Set<ExportSoldProductDTO> soldProducts;

    private ExportProductInfoDTO soldProd;

    public ExportSellerInfoDTO() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(byte age) {
        this.age = age;
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

    public byte getAge() {
        return age;
    }
}
