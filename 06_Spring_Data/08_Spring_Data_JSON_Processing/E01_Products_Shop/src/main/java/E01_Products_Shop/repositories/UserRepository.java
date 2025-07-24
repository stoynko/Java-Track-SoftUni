package E01_Products_Shop.repositories;

import E01_Products_Shop.data.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Set<User> findBySoldIsNotNullOrderByLastNameAscFirstNameAsc();

    @Query("""
           SELECT u FROM User AS u
           JOIN u.sold AS p
           WHERE p.buyer IS NOT NULL 
           ORDER BY u.lastName, u.firstName                                                      
           """)
    Set<User> findUserWithSoldProductsOrderByLastName();
}
