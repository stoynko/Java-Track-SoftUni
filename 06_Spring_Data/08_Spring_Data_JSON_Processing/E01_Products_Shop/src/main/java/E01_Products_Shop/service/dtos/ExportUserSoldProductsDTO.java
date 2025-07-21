package E01_Products_Shop.service.dtos;

public class ExportUserSoldProductsDTO {

    private String firstName;

    private String lastName;

    private ExportSoldProductDTO[] soldProducts;

    public ExportUserSoldProductsDTO() { }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSoldProducts(ExportSoldProductDTO[] soldProducts) {
        this.soldProducts = soldProducts;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ExportSoldProductDTO[] getSoldProducts() {
        return soldProducts;
    }
}
