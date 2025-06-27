package E01_Bookshop.repositories;

import E01_Bookshop.entities.*;
import E01_Bookshop.entities.enums.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.time.*;
import java.util.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByTitle(String title);
    Set<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);
    Set<Book> findAllByAuthor_FirstNameAndAuthor_LastName(String firstName, String lastName);

    //E01. Write a program that prints the titles of all books, for which the age restriction matches the given input (minor, teen or adult). Ignore the casing of the input.
    Set<Book> findByAgeGroupIs(AgeRestrictionType ageRestrictionType);

    //E02. Write a program that prints the titles of the golden edition books, which have less than 5000 copies.
    Set<Book> findByEditionTypeIsAndCopiesLessThan(EditionType editionType, int copies);

    //E03. Write a program that prints the titles and prices of books with price lower than 5 and higher than 40.
    Set<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lowerBound, BigDecimal upperBound);

    //E05. Write a program that prints the title, the edition type and the price of books, which are released before a given date. The date will be in the format dd-MM-yyyy.
    Set<Book> findByReleaseDateBefore(LocalDate inputDate);
}
