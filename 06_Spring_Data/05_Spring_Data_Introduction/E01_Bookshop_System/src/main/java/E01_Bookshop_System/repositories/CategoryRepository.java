package E01_Bookshop_System.repositories;

import E01_Bookshop_System.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {  }
