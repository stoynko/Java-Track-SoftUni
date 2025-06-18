package L01_Project_Setup.repositories;

import L01_Project_Setup.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {  }
