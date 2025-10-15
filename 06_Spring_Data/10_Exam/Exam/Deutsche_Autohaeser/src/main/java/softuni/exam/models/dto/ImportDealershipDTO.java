package softuni.exam.models.dto;

import com.google.gson.annotations.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;

public class ImportDealershipDTO {

    @Expose
    @NotNull
    @Length(min = 3, max = 30)
    private String name;

    @Expose
    @NotNull
    @Length(min = 5)
    private String description;

    public ImportDealershipDTO() { }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
