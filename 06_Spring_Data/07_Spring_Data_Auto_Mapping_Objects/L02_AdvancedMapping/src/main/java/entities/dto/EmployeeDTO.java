package entities.dto;

import java.math.*;

public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private BigDecimal salary;

    public EmployeeDTO() { }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", firstName, lastName, salary);
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
