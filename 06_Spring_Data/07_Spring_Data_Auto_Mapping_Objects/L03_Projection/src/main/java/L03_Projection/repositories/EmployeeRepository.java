package L03_Projection.repositories;

import L03_Projection.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByBirthdayBeforeOrderBySalaryDesc(LocalDate date);
}
