package E01_Products_Shop.data.dtos;

import org.hibernate.validator.constraints.*;

public class ImportCategoryDTO {

    @Length(min = 3, max = 15, message = "Category name must be between 3 and 15 characters")
    private String name;

    public ImportCategoryDTO() { }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
