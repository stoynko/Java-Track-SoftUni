package L01_Project_Setup.services;

import L01_Project_Setup.entities.*;
import L01_Project_Setup.repositories.*;
import jakarta.persistence.*;
import org.springframework.stereotype.*;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void register(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student get(long id) {
        return studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
