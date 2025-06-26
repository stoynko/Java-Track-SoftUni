package E01_Bookshop.repositories;

import E01_Bookshop.entities.*;
import E01_Bookshop.entities.enums.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByTitle(String title);
    Set<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);
    Set<Book> findAllByAuthor_FirstNameAndAuthor_LastName(String firstName, String lastName);

    /* E01. Write a program that prints the titles of all books, for which the age restriction matches the given input
     (minor, teen or adult). Ignore the casing of the input.*/
    Set<Book> findByAgeGroupIs(AgeRestrictionType ageRestrictionType);
}
