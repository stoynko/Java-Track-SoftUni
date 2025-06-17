package A_WorkingWithAbstraction.L03_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {

    private Map<String, Student> studentsMap;

    public StudentSystem() {
        this.studentsMap = new HashMap<>();
    }

    public Map<String, Student> getStudentsMap() {
        return this.studentsMap;
    }

    public void parseCommand(String[] args) {

        String command = args[0];
        if (command.equals("Create")) {
            String name = args[1];
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            studentsMap.putIfAbsent(name, new Student(name, age, grade));

        } else if (command.equals("Show")) {
            String name = args[1];
            if (studentsMap.containsKey(name)) {
                printStudentInformation(name);
            }
        }
    }

    private void printStudentInformation(String name) {
        Student student = studentsMap.get(name);
        String view = String.format("%s is %s years old.", student.getName(), student.getAge());

        if (student.getGrade() >= 5.00) {
            view += " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            view += " Average student.";
        } else {
            view += " Very nice person.";
        }

        System.out.println(view);
    }
}
