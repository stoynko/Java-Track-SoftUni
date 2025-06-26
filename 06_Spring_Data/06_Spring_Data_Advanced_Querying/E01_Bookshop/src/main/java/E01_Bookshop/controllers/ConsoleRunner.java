package E01_Bookshop.controllers;

import E01_Bookshop.entities.enums.*;
import E01_Bookshop.services.implementations.*;
import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
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

    public ConsoleRunner(CategoryServiceImpl categoryService, AuthorServiceImpl authorsService, BookServiceImpl booksService, Scanner scanner, Scanner scanner1) {
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
