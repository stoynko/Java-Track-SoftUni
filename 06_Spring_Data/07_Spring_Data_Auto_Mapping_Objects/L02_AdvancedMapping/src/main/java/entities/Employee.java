package entities;

import java.math.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

public class Employee {

    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDate birthday;
    private String address;
    private boolean onVacation;
    Employee manager;
    List<Employee> subordinates;

    public Employee() { }

    public Employee(String firstName, String lastName, BigDecimal salary, LocalDate birthday, String address, boolean onVacation, Employee manager, List<Employee> subordinates) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthday = birthday;
        this.address = address;
        this.onVacation = onVacation;
        this.manager = manager;
        this.subordinates = subordinates;
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
                             Available: %s
                             Manager: %s %s
                             Subordinates: %s
                             ──────────────
                             """, getClass().getSimpleName(),firstName, lastName, salary, String.format("%02d.%02d.%04d", birthday.getDayOfMonth(),
                                                                                                birthday.getMonthValue(),
                                                                                                birthday.getYear()),
                                  address, onVacation, manager.getFirstName(), manager.getLastName(), Collectors.joining(" "), subordinates);
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

    public void setOnVacationStatus(boolean onVacation) {
        this.onVacation = onVacation;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
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

    public boolean getOnVacationStatus() {
        return onVacation;
    }

    public Employee getManager() {
        return manager;
    }

    public List<Employee> getSubordinates() {
        return Collections.unmodifiableList(this.subordinates);
    }
}
