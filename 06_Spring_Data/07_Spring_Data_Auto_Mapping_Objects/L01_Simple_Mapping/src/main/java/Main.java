import entities.*;
import entities.dto.*;
import org.modelmapper.*;

import java.math.*;
import java.time.*;
import java.time.format.*;

public class Main {

/*Create a class Employee that has properties first name, last name, salary, birthday and address.
Create EmployeeDto class that will keep synthesized information about instances of the Employee class (only first name, last name and salary).
Create an instance of the employee object and use the ModelMapper to map the newly created Employee to an object of type EmployeeDto. */

    public static void main(String[] args) {

        ModelMapper mapper = new ModelMapper();
        Employee employeeA = createEmployee("Ivan", "Ivanov", 1000, "23.05.1989", "Bulgaria");

        EmployeeDTO employeeDTO = mapper.map(employeeA, EmployeeDTO.class);
        System.out.println(employeeDTO);
    }

    private static Employee createEmployee(String firstName, String lastName, double salary, String birthday, String address) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSalary(BigDecimal.valueOf(salary));
        employee.setBirthday(LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        employee.setAddress(address);
        return employee;
    }
}
