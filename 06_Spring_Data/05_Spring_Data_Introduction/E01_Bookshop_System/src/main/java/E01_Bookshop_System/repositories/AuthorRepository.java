package E01_Bookshop_System.repositories;

import E01_Bookshop_System.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Set<Author> findAuthorsByPublishedBooksBefore(LocalDate date);
}
