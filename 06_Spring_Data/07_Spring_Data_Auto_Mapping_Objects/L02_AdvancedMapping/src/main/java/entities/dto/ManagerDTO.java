package entities.dto;

import entities.*;

import java.util.*;
import java.util.stream.*;


public class ManagerDTO {

    private String firstName;
    private String lastName;
    private List<EmployeeDTO> subordinates;

    public ManagerDTO() { }

    public ManagerDTO(String firstName, String lastName, List<EmployeeDTO> subordinates) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        return String.format("%s %s | Employees: %d\n - %s", firstName,
                                                                     lastName,
                                                                     subordinates.size(),
                                                                     subordinates.stream()
                                                                     .map(s -> s.toString()).collect(Collectors.joining("\n - ")));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<EmployeeDTO> getSubordinates() {
        return subordinates;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSubordinates(List<EmployeeDTO> subordinates) {
        this.subordinates = subordinates;
    }
}
