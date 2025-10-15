package softuni.exam.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import softuni.exam.models.entity.*;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
