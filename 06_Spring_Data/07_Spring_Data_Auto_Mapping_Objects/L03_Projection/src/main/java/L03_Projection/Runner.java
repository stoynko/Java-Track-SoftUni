package L03_Projection;

import L03_Projection.entities.*;
import L03_Projection.entities.dto.*;
import L03_Projection.services.*;
import jakarta.persistence.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class Runner implements CommandLineRunner {

/* Use Hibernate to create and insert into a database a list of employees, for which each employee has first name, last name, salary,
   birthday, address and manager (another employee). Transform to EmployeeDto (first name, last name, salary, manager's last name)
   those employees who are born before 1990. Order them by salary descending and print them on the console. */

    private EmployeeService employeesService;

    public Runner(EmployeeService employeesService) {
        this.employeesService = employeesService;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int inputYear = Integer.parseInt(scanner.nextLine());


        List<EmployeeDTO> employees = employeesService.findEmployeesBornBefore(inputYear);
        employees.forEach(System.out::println);
    }
}
