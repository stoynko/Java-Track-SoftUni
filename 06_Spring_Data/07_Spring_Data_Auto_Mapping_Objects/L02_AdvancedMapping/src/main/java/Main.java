import entities.*;
import entities.dto.*;
import org.modelmapper.*;

import java.math.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Main {

/* Create class Employee with properties first name, last name, birthday, salary, information about whether the employee is on holiday, address,
manager (another employee) and list of employees that he/she is in charge of.
Create 2 types of data transfer objects – employee data transfer object and manager data transfer object.
•	EmployeeDto – first name, last name, salary
•	ManagerDto – first name, last name, list of EmployeeDtos that he/she is in charge of and their count
Create a list of several employees, then transform it to a list of ManagerDtos and print it on the console  */

    public static void main(String[] args) {

        ModelMapper mapper = new ModelMapper();
        Employee managerA = createEmployee("Ivan", "Ivanov", 1000, "23.05.1989", "Bulgaria", false, null, new ArrayList<>());
        managerA.setSubordinates(assembleTeam(managerA));

        ManagerDTO managerDTO = mapper.map(managerA, ManagerDTO.class);
        System.out.println(managerDTO);
    }

    private static List<Employee> assembleTeam(Employee managerA) {
        Employee employeeA = createEmployee("Georgi", "Ivanov", 1000, "12.05.1998", "Bulgaria", false, managerA, new ArrayList<>());
        Employee employeeB = createEmployee("Stefan", "Georgiev", 1500, "23.12.1997", "Bulgaria", true, managerA, new ArrayList<>());
        Employee employeeC = createEmployee("Petar", "Stefanov", 1200, "23.03.2001", "Bulgaria", false, managerA, new ArrayList<>());
        Employee employeeD = createEmployee("Viktoria", "Petrova", 1300, "23.07.1995", "Bulgaria", false, managerA, new ArrayList<>());
        Employee employeeE = createEmployee("Maria", "Ivanova", 1250, "23.09.1983", "Bulgaria", false, managerA, new ArrayList<>());
        return List.of(employeeA, employeeB, employeeC, employeeD, employeeE);
    }

    private static Employee createEmployee(String firstName, String lastName, double salary, String birthday, String address, Boolean isOnVacation, Employee manager, List<Employee> subordinates) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSalary(BigDecimal.valueOf(salary));
        employee.setBirthday(LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        employee.setAddress(address);
        employee.setOnVacationStatus(isOnVacation);
        employee.setManager(manager);
        employee.setSubordinates(subordinates);
        return employee;
    }
}
