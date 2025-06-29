package E01_Bookshop.repositories;

import E01_Bookshop.entities.*;
import E01_Bookshop.entities.enums.*;
import E01_Bookshop.entities.interfaces.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

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

    //E04. Write a program that prints the titles of all books that are NOT released in a given year.
    Set<Book> findByReleaseDateBeforeOrReleaseDateAfter(LocalDate startBound, LocalDate endBound);

    //E05. Write a program that prints the title, the edition type and the price of books, which are released before a given date. The date will be in the format dd-MM-yyyy.
    Set<Book> findByReleaseDateBefore(LocalDate inputDate);

    //E07. Write a program that prints the titles of books, which contain a given string (regardless of the casing).
    Set<Book> findByTitleContaining(String param);

    //E08. Write a program that prints the titles of books, which are written by authors, whose last name starts with a given string.
    Set<Book> findBookByAuthor_LastNameStartingWith(String param);

    //E09. Write a program that prints the number of books, whose title is longer than a given number.
    @Query("SELECT COUNT(b) FROM Book b WHERE LENGTH(b.title) > :charCount")
    int countBooksByTitleLongerThan(int charCount);

    /*E11. Write a program that prints information (title, edition type, age restriction and price) for a book by given title.
             When retrieving the book information select only those fields and do NOT include any other information in the returned result. */
    BookInfo findByTitleIs(String title);

    /*E12. Write a program that increases the copies of all books released after a given date with a given number.
             Print the total amount of book copies that were added.
        Input:
            •	On the first line – date in the format dd MMM yyyy. If a book is released after that date (exclusively),
                increase its book copies with the provided number from the second line of the input.
            •	On the second line – the number of book copies each book should be increased with.
        Output:
            •	Total number of books that were added to the database.*/
    @Query("UPDATE Book b SET b.copies = b.copies + :copiesCount WHERE b.releaseDate > :date")
    @Modifying
    @Transactional
    int updateBookCopiesWithAmount(LocalDate date, long copiesCount);
}
