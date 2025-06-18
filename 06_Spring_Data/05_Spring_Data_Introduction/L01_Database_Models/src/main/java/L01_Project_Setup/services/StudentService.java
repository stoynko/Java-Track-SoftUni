package L01_Project_Setup.services;

import L01_Project_Setup.entities.*;

public interface StudentService {

    void register(Student student);
    Student get(long id);
}
