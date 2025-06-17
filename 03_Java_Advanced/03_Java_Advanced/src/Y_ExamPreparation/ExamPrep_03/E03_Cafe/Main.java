package Y_ExamPreparation.ExamPrep_03.E03_Cafe;

public class Main {

    public static void main(String[] args) {

        Cafe cafe = new Cafe("Costa", 15);
        Employee employee = new Employee("Alexander", 30, "Bulgaria");
        System.out.println(employee); // Employee: Alexander, 30 from Bulgaria
        cafe.addEmployee(employee);
        System.out.println(cafe.removeEmployee("Employee")); //false
        Employee secondEmployee = new Employee("Sara", 24, "UK");
        Employee thirdEmployee = new Employee("Anna", 22, "Germany");
        cafe.addEmployee(secondEmployee);
        cafe.addEmployee(thirdEmployee);
        Employee oldestEmployee = cafe.getOldestEmployee();
        Employee employeeStephen = cafe.getEmployee("Sara");
        System.out.println(oldestEmployee); // Employee: Alexander, 30 from Bulgaria
        System.out.println(employeeStephen); //Employee: Sara, 24 from UK
        System.out.println(cafe.getCount()); // 3
        System.out.println(cafe.removeEmployee("Anna")); // true
        System.out.println(cafe.report());

    }
}
