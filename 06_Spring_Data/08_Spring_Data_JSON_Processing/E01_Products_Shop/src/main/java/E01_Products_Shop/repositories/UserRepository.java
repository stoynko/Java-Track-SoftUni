package E01_Products_Shop.repositories;

import E01_Products_Shop.data.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //@Query("SELECT u FROM User AS u WHERE size(u.sold) > 0 ORDER BY u.lastName, u.firstName")
    Set<User> findBySoldIsNotNullOrderByLastNameAscFirstNameAsc();
}
