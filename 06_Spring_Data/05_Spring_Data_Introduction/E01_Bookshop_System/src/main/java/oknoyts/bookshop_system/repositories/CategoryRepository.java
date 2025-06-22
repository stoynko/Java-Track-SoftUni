package oknoyts.bookshop_system.repositories;

import oknoyts.bookshop_system.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {  }
