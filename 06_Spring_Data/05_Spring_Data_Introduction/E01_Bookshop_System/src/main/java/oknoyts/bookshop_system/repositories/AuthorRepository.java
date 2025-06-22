package oknoyts.bookshop_system.repositories;

import oknoyts.bookshop_system.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
