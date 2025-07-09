package E01_Products_Shop.repositories;

import E01_Products_Shop.data.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
