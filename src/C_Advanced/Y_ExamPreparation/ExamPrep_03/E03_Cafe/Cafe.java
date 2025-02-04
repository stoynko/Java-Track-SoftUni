package C_Advanced.Y_ExamPreparation.ExamPrep_03.E03_Cafe;

import java.util.*;

public class Cafe {

        private String name;
        private int capacity;
        private List<Employee> employees;

        public Cafe(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
            this.employees = new ArrayList<>(this.capacity);
        }

        public void addEmployee(Employee employee) {
            if (employees.size() < capacity) {
                employees.add(employee);
            }
        }

        public boolean removeEmployee(String name) {

            boolean isRemoved = false;

            for (Employee employee : employees) {
                if (employee.getName().equals(name)) {
                    employees.remove(employee);
                    isRemoved = true;
                    break;
                }
            }
            return isRemoved;
        }


        public Employee getOldestEmployee() {
            int minAge = 0;
            Employee oldestEmployee = null;

            for (Employee employee : employees) {
                if (employee.getAge() > minAge) {
                    minAge = employee.getAge();
                    oldestEmployee = employee;
                }
            }
            return oldestEmployee;
        }

        public Employee getEmployee(String name) {
            Employee employee = null;
            for (Employee e: employees) {
                if (name.equals(e.getName())) {
                    return e;
                }
            }
            return null;
        }

        public int getCount() {
            return employees.size();
        }

        public String report() {

            StringBuilder output = new StringBuilder();

            output.append(String.format("Employees working at Cafe %s:", name)).append(System.lineSeparator());
            for (Employee employee : employees) {
                output.append(employee.toString()).append(System.lineSeparator());
            }

            return output.toString();
        }
    }
