package E01_Products_Shop.service.dtos;

import java.util.*;

public class ExportSellerWithListedProductsDTO {

    private String firstName;

    private String lastName;

    private byte age;

    private ExportProductInfoDTO soldProducts;

    public ExportSellerWithListedProductsDTO() {
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

    public void setSoldProducts(ExportProductInfoDTO soldProducts) {
        this.soldProducts = soldProducts;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ExportProductInfoDTO getSoldProducts() {
        return soldProducts;
    }

    public byte getAge() {
        return age;
    }
}
