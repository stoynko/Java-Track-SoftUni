package L03_Projection.entities;

import jakarta.persistence.*;

import java.math.*;
import java.time.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Basic
    private BigDecimal salary;

    @Basic
    private LocalDate birthday;

    @Basic
    private String address;

    @Column(name = "on_vacation")
    private boolean onVacation;

    @ManyToOne
    Employee manager;

    public Employee() { }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOnVacation(boolean onVacation) {
        this.onVacation = onVacation;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public boolean isOnVacation() {
        return onVacation;
    }

    public Employee getManager() {
        return manager;
    }
}

