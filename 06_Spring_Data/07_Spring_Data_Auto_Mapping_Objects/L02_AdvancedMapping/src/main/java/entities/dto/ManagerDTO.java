package entities.dto;

import entities.*;

import java.util.*;

public class ManagerDTO {

    private String firstName;
    private String lastName;
    private List<Employee> subordinates;

    public ManagerDTO() { }

    public ManagerDTO(String firstName, String lastName, List<Employee> subordinates) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subordinates = subordinates;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }
}
