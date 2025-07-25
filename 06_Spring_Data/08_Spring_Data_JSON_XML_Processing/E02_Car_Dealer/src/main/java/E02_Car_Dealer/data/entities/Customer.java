package E02_Car_Dealer.data.entities;

import jakarta.persistence.*;

import java.time.*;

@Entity(name = "customers")
public class Customer extends BaseEntity {

    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "is_young_driver")
    private Boolean isYoungDriver;

    public Customer() { }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Boolean getYoungDriver() {
        return isYoungDriver;
    }
}
