package softuni.exam.models.entity;

import jakarta.persistence.*;

import java.time.*;

@Entity
@Table(name = "dealers")
public class Dealer extends BaseEntity {

    @Column(name = "average_monthly_turnover", nullable = false)
    private Double averageMonthlyTurnover;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "offering_car_id")
    private Car offeringCar;

    public Dealer() { }

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

    public void setOfferingCar(Car offeringCar) {
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

    public Car getOfferingCar() {
        return offeringCar;
    }
}

