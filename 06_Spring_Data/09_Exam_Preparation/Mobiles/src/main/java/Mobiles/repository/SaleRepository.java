package Mobiles.repository;

import Mobiles.data.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
