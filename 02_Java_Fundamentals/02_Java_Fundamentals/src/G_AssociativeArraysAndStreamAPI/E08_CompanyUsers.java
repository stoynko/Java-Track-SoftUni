package G_AssociativeArraysAndStreamAPI;

import java.util.*;

public class E08_CompanyUsers {

/*Write a program which keeps the information about companies and their employees. You will receive company names and an employees' id
until you receive the "End" command. Add each employee to the given company. Keep in mind that a company cannot have two employees with the same id.
Print the company name and each employee's id in the following format:
    "{company_name}
    -- {id1}
    -- {id2}
    -- {idN}"

Input / Constraints:
    •	Until you receive "End", the input come in the format: "{companyName} -> {employeeId}".
    •	The input always will be valid.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> employeesMap = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] data = input.split(" -> ");
            String companyName = data[0];
            String employeeID = data[1];

            if (!employeesMap.containsKey(companyName)) {
                employeesMap.put(companyName, new ArrayList<>());
                employeesMap.get(companyName).add(employeeID);
            } else {
                if (employeesMap.get(companyName).contains(employeeID)) {
                    input = scanner.nextLine();
                    continue;
                } else {
                    employeesMap.get(companyName).add(employeeID);
                }
            }
            input = scanner.nextLine();
        }
        employeesMap.forEach((company, employees) -> {
            System.out.println(company);
            for (String employeesID : employees) {
                System.out.printf("-- %s%n", employeesID);
            }
        });
    }
}