package E01_Bookshop.controllers;

import E01_Bookshop.entities.enums.*;
import E01_Bookshop.entities.interfaces.*;
import E01_Bookshop.services.*;
import E01_Bookshop.services.implementations.*;
import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.math.*;
import java.util.*;

/* Create database for a Bookshop System. A bookshop keeps books. A book can have one author and many categories.
Each category can be placed on many books. Let's create a class for each main table.
    •	Book - id, title (between 1...50 symbols), description (optional, up to 1000 symbols), edition type (NORMAL, PROMO or GOLD),
        price, copies, release date (optional), age restriction (MINOR, TEEN or ADULT)
    •	Author - id, first name (optional) and last name
    •	Category - id, name
Assume everything, which is not market (optional), is mandatory.
The final schema of the database should look like that:
    ┌─────────────┐  ┌─────────────────┐
    │  authors    │  │     books       │
    ├─────────────┤  ├─────────────────┤
    │ Column Name │  │   Column Name   │
    ├─────────────┤  ├─────────────────┤
    │ author_id   │  │ book_id         │
    │ first_name  │  │ age_restriction │
    │ last_name   │  │ copies          │
    │             │  │ description     │
    │             │  │ edition_type    │
    │             │  │ price           │
    │             │  │ release_date    │
    │             │  │ title           │
    │             │  │ author_id       │
    └─────────────┘  └─────────────────┘
    ┌─────────────┐  ┌──────────────────┐
    │ categories  │  │ books_categories │
    ├─────────────┤  ├──────────────────┤
    │ Column Name │  │   Column Name    │
    ├─────────────┤  ├──────────────────┤
    │ category_id │  │ book_id          │
    │ name        │  │ category_id      │
    └─────────────┘  └──────────────────┘
Write the following queries:
    1.	Get all books after the year 2000. Print only their titles.
    2.	Get all authors with at least one book with a release date before 1990. Print their first name and last name.
    3.	Get all authors, ordered by the number of their books (descending). Print their first name, last name and book count.
    4.	Get all books from author George Powell, ordered by their release date (descending), then by book title (ascending).
        Print the book's title, release date and copies. */

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final CategoryServiceImpl categoriesService;
    private final AuthorServiceImpl authorsService;
    private final BookServiceImpl booksService;
    private final Scanner scanner;

    public ConsoleRunner(CategoryServiceImpl categoryService, AuthorServiceImpl authorsService, BookServiceImpl booksService, Scanner scanner, Scanner scanner1, BookService bookService) {
        this.categoriesService = categoryService;
        this.authorsService = authorsService;
        this.booksService = booksService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        //E01. Write a program that prints the titles of all books, for which the age restriction matches the given input (minor, teen or adult). Ignore the casing of the input.
        //booksService.printAllBooksForAgeGroup(AgeRestrictionType.valueOf((scanner.nextLine()).toUpperCase()));

        //E02. Write a program that prints the titles of the golden edition books, which have less than 5000 copies.
        //booksService.printAllBooksByEditionTypeAndCopies(EditionType.GOLD, 5000);

        //E03. Write a program that prints the titles and prices of books with price lower than 5 and higher than 40.
        //booksService.findByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40));

        //E04. Write a program that prints the titles of all books that are NOT released in a given year.
        //booksService.findByReleaseYearNotEqualTo(Integer.parseInt(scanner.nextLine()));
        //booksService.findByReleaseDateNotIn(Integer.parseInt(scanner.nextLine()));

        //E05. Write a program that prints the title, the edition type and the price of books, which are released before a given date. The date will be in the format dd-MM-yyyy.
        //booksService.findByReleaseDateBefore(Integer.parseInt(scanner.nextLine()),
        //                                     Integer.parseInt(scanner.nextLine()),
        //                                     Integer.parseInt(scanner.nextLine()));

        //E06. Write a program that prints the names of those authors, whose first name ends with a given string.
        //this.authorsService.findByFirstNameIsEndingWith(scanner.nextLine());

        //E07. Write a program that prints the titles of books, which contain a given string (regardless of the casing).
        //booksService.findByTitleContaining(scanner.nextLine());

        //E08. Write a program that prints the titles of books, which are written by authors, whose last name starts with a given string.
        //booksService.findByAuthorLastNameStartingWith(scanner.nextLine());

        //E09. Write a program that prints the number of books, whose title is longer than a given number.
        //System.out.println(booksService.countByBookTitleLongerThan(Integer.parseInt(scanner.nextLine())));
        //System.out.println(booksService.countByBookTitleLengthLongerThan(Integer.parseInt(scanner.nextLine())));

        //E10. Write a program that prints the total number of book copies by author. Order the results descending by total book copies.
        //authorsService.findByBookCopiesCount();

        /*E11. Write a program that prints information (title, edition type, age restriction and price) for a book by given title.
             When retrieving the book information select only those fields and do NOT include any other information in the returned result.*/
        //booksService.printBookInfo(scanner.nextLine());

        /*E12. Write a program that increases the copies of all books released after a given date with a given number.
             Print the total amount of book copies that were added.
        Input:
            •	On the first line – date in the format dd MMM yyyy. If a book is released after that date (exclusively),
                increase its book copies with the provided number from the second line of the input.
            •	On the second line – the number of book copies each book should be increased with.
        Output:
            •	Total number of books that were added to the database.*/
        //booksService.updateBookCopiesWithAmount(scanner.nextLine(), Integer.parseInt(scanner.nextLine()));

        //E13. Write a program that removes from the database those books, which copies are lower than a given number. Print the number of books that were deleted from the database.


    }



    private void seedData() throws IOException {
        if (!this.categoriesService.areCategoriesImported()) {
            this.categoriesService.seedCategories();
        }
        if (!this.authorsService.areAuthorsImported()) {
            this.authorsService.seedAuthors();
        }
        if (!this.booksService.areBooksImported()) {
            this.booksService.seedBooks();
        }
    }
}
