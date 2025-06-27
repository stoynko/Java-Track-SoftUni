package E01_Bookshop.repositories;

import E01_Bookshop.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY SIZE(a.publishedBooks) DESC")
    Set<Author> findAllByOrderByPublishedBooksCountDesc();

    //E06. Write a program that prints the names of those authors, whose first name ends with a given string.
    Set<Author> findByFirstNameIsEndingWith(String param);
}
