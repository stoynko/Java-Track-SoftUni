package Mobiles.data.dto.seller;

import com.google.gson.annotations.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;

import java.io.*;

public class ImportSellerDTO implements Serializable {

    @Expose
    @NotNull
    @Length(min = 2, max = 30)
    private String firstName;

    @Expose
    @NotNull
    @Length(min = 2, max = 30)
    private String lastName;

    @Expose
    @NotNull
    @Length(min = 3, max = 6)
    private String personalNumber;

    public ImportSellerDTO() { }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }
}
