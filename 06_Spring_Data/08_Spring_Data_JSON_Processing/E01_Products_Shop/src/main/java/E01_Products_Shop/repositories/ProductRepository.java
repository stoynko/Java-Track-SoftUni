package E01_Products_Shop.repositories;

import E01_Products_Shop.data.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
