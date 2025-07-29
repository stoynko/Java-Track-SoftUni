package Mobiles.repository;

import Mobiles.data.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

}
