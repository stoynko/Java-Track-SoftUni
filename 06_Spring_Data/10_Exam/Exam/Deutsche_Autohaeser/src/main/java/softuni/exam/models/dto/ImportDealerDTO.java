package softuni.exam.models.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;

import java.time.*;

@JacksonXmlRootElement(localName = "dealer")
public class ImportDealerDTO {

    @JacksonXmlProperty(localName = "average_monthly_turnover")
    @NotNull
    @Positive
    private Double averageMonthlyTurnover;

    @JacksonXmlProperty(localName = "birthday")
    private LocalDate birthday;

    @JacksonXmlProperty(localName = "first_name")
    @NotNull
    @Length(min = 2, max = 30)
    private String firstName;

    @JacksonXmlProperty(localName = "last_name")
    @NotNull
    @Length(min = 2, max = 30)
    private String lastName;

    @JacksonXmlProperty(localName = "salary")
    @NotNull
    @Positive
    private Double salary;

    @JacksonXmlProperty(localName = "offering_car_id")
    @NotNull
    private Long offeringCar;

    public ImportDealerDTO() { }

    public void setAverageMonthlyTurnover(Double averageMonthlyTurnover) {
        this.averageMonthlyTurnover = averageMonthlyTurnover;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setOfferingCar(Long offeringCar) {
        this.offeringCar = offeringCar;
    }

    public Double getAverageMonthlyTurnover() {
        return averageMonthlyTurnover;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public Long getOfferingCar() {
        return offeringCar;
    }
}
