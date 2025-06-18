package L01_Project_Setup;

import L01_Project_Setup.entities.*;
import L01_Project_Setup.services.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class Main implements CommandLineRunner {

    private final StudentService studentService;

    public Main(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student("Pesho");
        studentService.register(student);
        Student fromDB = studentService.get(2);
        System.out.println(fromDB.getName());
    }
}
