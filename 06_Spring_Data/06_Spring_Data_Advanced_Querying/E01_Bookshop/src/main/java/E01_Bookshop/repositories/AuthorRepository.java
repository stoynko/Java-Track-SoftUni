package E01_Bookshop.repositories;

import E01_Bookshop.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.query.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY SIZE(a.publishedBooks) DESC")
    Set<Author> findAllByOrderByPublishedBooksCountDesc();

    //E06. Write a program that prints the names of those authors, whose first name ends with a given string.
    Set<Author> findByFirstNameIsEndingWith(String param);

    /*E14. Using Workbench (or other similar tool) create a stored procedure, which receives an author's first and last name and returns
           the total amount of books the author has written. Then write a program that receives an author's name and prints the total number
           of books the author has written by using the stored procedure you've just created.*/
    @Procedure(procedureName = "usp_count_books_from_author", outputParameterName = "result")
    int findBookCountByAuthor(String firstName, String lastName);

}
