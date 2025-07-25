package E02_Car_Dealer.data.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity(name = "suppliers")
public class Supplier extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_importer", nullable = false)
    private Boolean isImporter;

    @OneToMany(mappedBy = "supplier", targetEntity = Part.class)
    private List<Part> partsList;

    public Supplier() {
        this.partsList = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }

    public void setPartsList(List<Part> partsList) {
        this.partsList = partsList;
    }

    public String getName() {
        return name;
    }

    public Boolean getImporter() {
        return isImporter;
    }

    public List<Part> getPartsList() {
        return partsList;
    }
}
