package softuni.exam.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import softuni.exam.models.entity.*;

@Repository
public interface DealershipRepository extends JpaRepository<Dealership, Long> {

}
