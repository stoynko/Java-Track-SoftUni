package L03_Projection.entities.dto;

import java.math.*;

public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private EmployeeDTO manager;

    public EmployeeDTO() { }

    @Override
    public String toString() {
        return String.format("%s %s %.2f - Manager: %s",
                firstName, lastName, salary, manager == null ? "[no manager]" : manager.firstName);
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

    public void setManager(EmployeeDTO manager) {
        this.manager = manager;
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

    public EmployeeDTO getManager() {
        return manager;
    }
}
