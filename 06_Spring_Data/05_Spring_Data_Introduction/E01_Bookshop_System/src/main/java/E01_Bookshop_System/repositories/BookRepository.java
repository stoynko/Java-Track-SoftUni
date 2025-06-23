package E01_Bookshop_System.repositories;

import E01_Bookshop_System.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByTitle(String title);
    Set<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);
}
