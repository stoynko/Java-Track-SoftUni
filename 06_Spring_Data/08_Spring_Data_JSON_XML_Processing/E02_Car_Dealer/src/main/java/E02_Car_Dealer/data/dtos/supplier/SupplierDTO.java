package E02_Car_Dealer.data.dtos.supplier;

public class SupplierDTO {

    private String name;

    private Boolean isImporter;

    public SupplierDTO() { }

    public void setName(String name) {
        this.name = name;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }

    public String getName() {
        return name;
    }

    public Boolean getImporter() {
        return isImporter;
    }
}
