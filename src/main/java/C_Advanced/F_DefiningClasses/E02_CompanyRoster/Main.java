package C_Advanced.F_DefiningClasses.E02_CompanyRoster;

import java.util.*;

public class Main {

/*Define a class Employee that holds the following information: name, salary, position, department, email, and age.
The name, salary, position, and department are mandatory, while the rest are optional.
Your task is to write a program that takes N lines of information about employees from the console and calculates the department with
the highest average salary, and prints for each employee in that department his name, salary, email, and age - sorted by salary in descending order.
If an employee doesn't have an email – in place of that field, you should print "n/a" instead, if he doesn't have an age – print "-1" instead.
Print in the following format:
    "Highest Average Salary: {department}
    {name1} {salary1} {email1} {age1}
    {name2} {salary2} {email2} {age2}
    …
    {nameN} {salaryN} {emailN} {ageN}"

The salary should be printed to two decimal places after the separator.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, List<Employee>> departments = new HashMap<>();

        int inputCounts = Integer.parseInt(scanner.nextLine());

        for (int count = 1; count <= inputCounts; count++) {

            String[] inputData = scanner.nextLine().split(" ");
            String name = inputData[0];
            double salary = Double.parseDouble(inputData[1]);
            String position = inputData[2];
            String department = inputData[3];
            String email = "n/a";
            int age = -1;

            if (inputData.length == 5) {
                String data = inputData[4];
                if (data.contains("@")) {
                    email = data;
                } else {
                    age = Integer.parseInt(data);
                }
            } else if (inputData.length == 6) {
                email = inputData[4];
                age = Integer.parseInt(inputData[5]);
            }

            Employee employee = new Employee(name, salary, position, department, email, age);
            departments.putIfAbsent(department, new ArrayList<>());
            departments.get(department).add(employee);
        }

        String highestAverageDep = departments.entrySet()
                .stream().max(Comparator.comparing(entry -> getAverage(entry.getValue())))
                .get().getKey();

        System.out.printf("Highest Average Salary: %s\n", highestAverageDep);
        List<Employee> sortedEmployees = departments.get(highestAverageDep);
        sortedEmployees.sort(Comparator.comparing(e -> e.getSalary()));
        Collections.reverse(sortedEmployees);

        sortedEmployees.forEach(employee -> {
            System.out.printf("%s %.2f %s %d\n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        });
    }

    public static double getAverage(List<Employee> employees) {

        double sum = 0;

        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }
}
