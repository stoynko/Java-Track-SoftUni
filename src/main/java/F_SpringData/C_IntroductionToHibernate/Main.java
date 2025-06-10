
import entities.*;
import jakarta.persistence.*;

import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft-uni-db");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        // E02_ChangeCasing
        //changeCasing(entityManager);

        // E03_ContainsEmployee
        //checkIfContainsEmployee(entityManager);

        // E04_EmployeesWithSalaryAbove50000
        //getEmployeesWithSalaryAbove(entityManager, 50000);

        // E05_EmployeesFromDepartment
        //getEmployeesFromDepartment(entityManager, "Research and Development");

        // E06_AddingNewAddressUpdatingEmployee
        //updateEmployeeAddress(entityManager, "Vitoshka 15");

        // E07_AddressesWithEmployeeCount
        getAddressWithEmployeeCount(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();
    }



    /* E02_ChangeCasing - Use the soft_uni database. Persist all towns from the database. Detach those whose name length is more than 5 symbols.
    Then transform the names of all attached towns to uppercase and save them to the database. */
    private static void changeCasing(EntityManager entityManager) {
        entityManager.createQuery("UPDATE Town SET name = UPPER(name) WHERE length(name) > 5 ").executeUpdate();
        entityManager.getTransaction().commit();
    }

    /* E03_ContainsEmployee - Use the soft_uni database. Write a program that checks if a given employee's name is contained in the database. */
    private static void checkIfContainsEmployee(EntityManager entityManager) throws IOException {
        String[] employeeNames = READER.readLine().split("\\s+");

        List<Employee> resultList = entityManager
                .createQuery("FROM Employee WHERE firstName = :firstName AND lastName = :lastName", Employee.class)
                .setParameter("firstName", employeeNames[0])
                .setParameter("lastName", employeeNames[1])
                .getResultList();

        System.out.println(!resultList.isEmpty() ? "Yes" : "No");
    }

    /* E04_EmployeesWithSalaryAbove50000 - Write a program that gets the first name of all employees who have a salary over 50 000. */
    private static void getEmployeesWithSalaryAbove(EntityManager entityManager, double salaryParameter) {
        entityManager.createQuery("FROM Employee WHERE salary > :salaryParam", Employee.class).
                setParameter("salaryParam", salaryParameter)
                .getResultStream().forEach(employee -> System.out.println(employee.getFirstName()));
    }

    /* E05_EmployeesFromDepartment - Extract all employees from the Research and Development department. Order them by salary (in ascending order),
    then by id (in ascending order). Print only their first name, last name, department name and salary. */
    private static void getEmployeesFromDepartment(EntityManager entityManager, String departmentParameter) {
        entityManager.createQuery("FROM Employee WHERE department.name = :departmentName ORDER BY salary, id", Employee.class)
                .setParameter("departmentName", departmentParameter)
                .getResultStream().forEach(employee ->
                        System.out.printf("%s %s from %s - $%.2f\n",
                                employee.getFirstName(),
                                employee.getLastName(),
                                departmentParameter,
                                employee.getSalary())
                );
    }

    /* E06_AddingNewAddressUpdatingEmployee - Create a new address with the text "Vitoshka 15".
    Set that address to an employee with a last name, given as input. */
    private static void updateEmployeeAddress(EntityManager entityManager, String newAddress) throws IOException {
        String employeeLastName = READER.readLine();
        Address address = new Address();
        address.setText(newAddress);
        entityManager.persist(address);

        Employee employee = entityManager.createQuery("FROM Employee WHERE lastName =: eLastName", Employee.class)
                .setParameter("eLastName", employeeLastName)
                .getSingleResult();

        employee.setAddress(address);
        entityManager.persist(employee);
    }

    /* Find all addresses, ordered by the number of employees who live there (descending).
    Take only the first 10 addresses and print their address text, town name and employee count. */
    private static void getAddressWithEmployeeCount(EntityManager entityManager) {

    }
}
