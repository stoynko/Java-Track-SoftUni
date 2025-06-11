
import entities.*;
import jakarta.persistence.*;

import java.io.*;
import java.math.*;
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
        //getAddressWithEmployeeCount(entityManager);

        // E08_GetEmployeesWithProject
        //getEmployeeWithProject(entityManager);

        // E09_FindTheLatest10Projects
        //findTheLatestProjects(entityManager);

        // E10_IncreaseSalaries
        increaseSalaries(entityManager);

        //E11_FindEmployeesByFirstName
        findEmployeeByFirstName(entityManager);



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

    /* E07_AddressesWithEmployeeCount - Find all addresses, ordered by the number of employees who live there (descending).
    Take only the first 10 addresses and print their address text, town name and employee count. */

    private static void getAddressWithEmployeeCount(EntityManager entityManager) {
        List<Address> resultList = entityManager.createQuery("FROM Address ORDER BY SIZE (employees) DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        resultList.forEach(address -> System.out.printf(address.getEmployees().size() > 1 ? "%s, %s - %d employees\n" :
                        "%s, %s - %d employee\n",
                address.getText(),
                address.getTown().getName(),
                address.getEmployees().size()));
    }

    /* E08_GetEmployeesWithProject - Get an employee by his/her id. Print only his/her first name, last name, job title and projects (only their names).
       The projects should be ordered by name (ascending). The output should be printed in the format given in the example. */

    private static void getEmployeeWithProject(EntityManager entityManager) {
        Employee employee = entityManager.find(Employee.class, Integer.parseInt(READER.readLine()));

        if (employee.getProjects().isEmpty()) {
            return;
        }

        System.out.printf("%s %s - %s\n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        employee.getProjects().forEach(project -> System.out.printf("\t%s\n", project.getName()));
    }

    /* E09_FindTheLatest10Projects - Write a program that prints the last 10 started projects. Print their name, description, start and end date and sort them by name lexicographically. */

    private static void findTheLatestProjects(EntityManager entityManager) {
        entityManager.createQuery("FROM Project ORDER BY startDate DESC, name ASC", Project.class)
                .setMaxResults(10).getResultStream().forEach(project -> {
                    System.out.printf("Project name: %s\n", project.getName());
                    System.out.printf("\tProject description: %s\n", project.getDescription());
                    System.out.printf("\tProject start date: %s\n", project.getStartDate());
                    System.out.printf("\tProject end date: %s\n", project.getEndDate());
                });
    }

    /* E10_IncreaseSalaries - Write a program that increases the salaries of all employees, who are in the Engineering, Tool Design, Marketing,
    or Information Services departments by 12%. Then print the first name, the last name and the salary for the employees,
    whose salary was increased. */

    private static void increaseSalaries(EntityManager entityManager) {
        entityManager.createQuery("FROM Employee " +
                        "WHERE department.name IN('Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class)
                .getResultStream().forEach(employee -> {
                    employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
                    entityManager.persist(employee);
                    System.out.printf("%s %s ($%.2f)\n", employee.getFirstName(), employee.getLastName(), employee.getSalary());
                });
    }

    /* E11_FindEmployeesByFirstName - Write a program that finds all employees, whose first name starts with a pattern given as input from the console.
       Print their first and last names, their job title and salary in the format given in the example below. */

    private static void findEmployeeByFirstName(EntityManager entityManager) throws IOException {
        String userInput = READER.readLine();
        entityManager.createQuery("FROM Employee WHERE firstName LIKE(userInput)")
    }
}
