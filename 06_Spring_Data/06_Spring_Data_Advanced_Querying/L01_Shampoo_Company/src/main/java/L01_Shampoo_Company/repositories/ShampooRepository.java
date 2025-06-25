package L01_Shampoo_Company.repositories;

import L01_Shampoo_Company.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    //private
}
