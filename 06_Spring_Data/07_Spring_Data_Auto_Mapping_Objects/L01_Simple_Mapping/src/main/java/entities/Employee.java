package entities;

import java.math.*;
import java.time.*;

public class Employee {

    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDate birthday;
    private String address;

    public Employee() { }

    public Employee(String firstName, String lastName, BigDecimal salary, LocalDate birthday, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthday = birthday;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("""
                             %s
                             ───
                             First Name: %s
                             Last Name: %s
                             Salary: %.2f
                             Birthday: %s
                             Address: %s
                             ──────────────
                             """, getClass().getSimpleName(),firstName, lastName, salary, String.format("%02d.%02d.%04d", birthday.getDayOfMonth(),
                                                                                                birthday.getMonthValue(),
                                                                                                birthday.getYear()),
                                  address);
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
}
