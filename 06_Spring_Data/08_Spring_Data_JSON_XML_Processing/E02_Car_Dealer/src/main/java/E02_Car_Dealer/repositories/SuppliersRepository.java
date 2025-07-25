package E02_Car_Dealer.repositories;

import E02_Car_Dealer.data.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface SuppliersRepository extends JpaRepository<Supplier, Long> {

}
