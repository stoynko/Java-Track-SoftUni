package E01_Bookshop_System.repositories;

import E01_Bookshop_System.entities.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY SIZE(a.publishedBooks) DESC")
    Set<Author> findAllByOrderByPublishedBooksCountDesc();
}
