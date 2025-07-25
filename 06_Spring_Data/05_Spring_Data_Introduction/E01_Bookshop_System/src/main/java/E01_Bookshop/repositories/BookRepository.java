package E01_Bookshop.repositories;

import E01_Bookshop.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByTitle(String title);
    Set<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);
    Set<Book> findAllByAuthor_FirstNameAndAuthor_LastName(String firstName, String lastName);
}
