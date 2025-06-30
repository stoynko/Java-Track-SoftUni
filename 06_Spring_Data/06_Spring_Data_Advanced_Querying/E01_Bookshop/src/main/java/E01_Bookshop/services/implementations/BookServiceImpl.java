package E01_Bookshop.services.implementations;

import E01_Bookshop.entities.*;
import E01_Bookshop.entities.enums.*;
import E01_Bookshop.entities.interfaces.*;
import E01_Bookshop.repositories.*;
import E01_Bookshop.services.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.math.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

@Service
public class BookServiceImpl implements BookService {

    private final String BOOKS_FILE_PATH = "06_Spring_Data/06_Spring_Data_Advanced_Querying/E01_Bookshop/src/main/resources/files/books.txt";
    private final BookRepository booksRepository;
    private final AuthorServiceImpl authorsService;
    private final CategoryServiceImpl categoriesService;

    public BookServiceImpl(BookRepository booksRepository, AuthorServiceImpl authorsService, CategoryServiceImpl categoriesService) {
        this.booksRepository = booksRepository;
        this.authorsService = authorsService;
        this.categoriesService = categoriesService;
    }

    @Override
    public boolean areBooksImported() {
        return booksRepository.count() > 0;
    }

    @Override
    public void seedBooks() throws IOException {

        Set<Book> books = new HashSet<>();
        for (String line : Files.readAllLines(Path.of(BOOKS_FILE_PATH))) {
            String formattedLine = line.trim();
            String[] dataInput = formattedLine.split("\\s+");

            EditionType editionType = EditionType.values()[Integer.parseInt(dataInput[0])];
            LocalDate releaseDate = LocalDate.parse(dataInput[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            int copies = Integer.parseInt(dataInput[2]);
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(dataInput[3]));
            AgeRestrictionType ageGroup = AgeRestrictionType.values()[Integer.parseInt(dataInput[4])];
            String title = Arrays.stream(dataInput).skip(5).collect(Collectors.joining(" "));

            Author author = authorsService.getRandomAuthor();
            Set<Category> categories = categoriesService.getRandomCategories();
            Book book = new Book(title, author, categories, editionType, price, copies, releaseDate, ageGroup);

            if (!this.booksRepository.existsByTitle(title)) {
                booksRepository.saveAndFlush(book);
            }
        }
    }

    @Override
    public void printAllBooksAfter(LocalDate date) {
        Set<Book> booksSet = this.booksRepository.findAllByReleaseDateAfter(date);
        booksSet.forEach(book -> System.out.printf("%s\n", book.getTitle()));
    }

    @Override
    public void printAllBooksBy(String firstName, String lastName) {
        Set<Book> booksSet = this.booksRepository.findAllByAuthor_FirstNameAndAuthor_LastName(firstName, lastName);
        booksSet.stream().sorted(Comparator.comparing(Book::getReleaseDate).reversed().thenComparing(Book::getTitle))
                .forEach(book -> System.out.printf("Title: %s, Release Date: %s, Copies Sold:%d\n",
                                                                                    book.getTitle(),
                                                                                    book.getReleaseDate(),
                                                                                    book.getCopies()));
    }

    public void printAllBooksForAgeGroup(AgeRestrictionType ageRestrictionType) {
        Set<Book> bookSet = this.booksRepository.findByAgeGroupIs(ageRestrictionType);
        bookSet.forEach(book -> System.out.println(book.getTitle()));
    }

    public void printAllBooksByEditionTypeAndCopies(EditionType editionType, int copies) {
        Set<Book> bookSet = this.booksRepository.findByEditionTypeIsAndCopiesLessThan(editionType, copies);
        bookSet.forEach(book -> System.out.println(book.getTitle()));
    }

    //E03. Write a program that prints the titles and prices of books with price lower than 5 and higher than 40.
    public void findByPriceLessThanOrPriceGreaterThan(BigDecimal lowerBound, BigDecimal upperBound) {
        Set<Book> bookSet = this.booksRepository.findByPriceLessThanOrPriceGreaterThan(lowerBound, upperBound);
        bookSet.forEach(book -> System.out.printf("%s - $%.2f\n", book.getTitle(), book.getPrice()));
    }

    //E04. Write a program that prints the titles of all books that are NOT released in a given year.
    public void findByReleaseYearNotEqualTo(int inputYear) {
        this.booksRepository.findAll().stream().forEach(book -> {
            if (book.getReleaseDate().getYear() != inputYear) {
                System.out.println(book.getTitle());
            }
        });
    }

    //E04. Write a program that prints the titles of all books that are NOT released in a given year.
    public void findByReleaseDateNotIn(int inputYear) {
        LocalDate startBound = LocalDate.of(inputYear, 01, 01);
        LocalDate endBound = LocalDate.of(inputYear, 12, 31);
        this.booksRepository.findByReleaseDateBeforeOrReleaseDateAfter(startBound, endBound)
                .forEach(book -> System.out.println(book.getTitle()));
    }

    //E05. Write a program that prints the title, the edition type and the price of books, which are released before a given date. The date will be in the format dd-MM-yyyy.
    public void findByReleaseDateBefore(int inputDay, int inputMonth, int inputYear) {
        Set<Book> bookSet = this.booksRepository.findByReleaseDateBefore(LocalDate.of(inputYear, inputMonth, inputDay));
        bookSet.forEach(book -> {
            System.out.printf("%s %s %.2f\n", book.getTitle(), book.getEditionType(), book.getPrice());
        });
    }

    //E07. Write a program that prints the titles of books, which contain a given string (regardless of the casing).
    public void findByTitleContaining(String param) {
        Set<Book> bookSet = this.booksRepository.findByTitleContaining(param);
        bookSet.forEach(book -> System.out.println(book.getTitle()));
    }

    //E08. Write a program that prints the titles of books, which are written by authors, whose last name starts with a given string.
    public void findByAuthorLastNameStartingWith(String param) {
        Set<Book> bookSet = this.booksRepository.findBookByAuthor_LastNameStartingWith(param);
        bookSet.forEach(book -> System.out.println(book.getTitle()));
    }

    //E09. Write a program that prints the number of books, whose title is longer than a given number.
    public int countByBookTitleLongerThan(int charCount) {
        int countOfBooks = 0;
        for (Book book : this.booksRepository.findAll()) {
            if (book.getTitle().length() > charCount) {
                countOfBooks += 1;
            }
        }
        return countOfBooks;
    }

    public int countByBookTitleLengthLongerThan(int charCount) {
        return this.booksRepository.countBooksByTitleLongerThan(charCount);
    }

    /*E11. Write a program that prints information (title, edition type, age restriction and price) for a book by given title.
           When retrieving the book information select only those fields and do NOT include any other information in the returned result. */
    public void printBookInfo (String title) {
        BookInfo book = booksRepository.findByTitleIs(title);
        System.out.printf("%s %s %s %.2f\n", book.getTitle(), book.getEditionType().name(),
                                           book.getAgeGroup().name(), book.getPrice());
    }

    /*E12. Write a program that increases the copies of all books released after a given date with a given number.
             Print the total amount of book copies that were added.
        Input:
            •	On the first line – date in the format dd MMM yyyy. If a book is released after that date (exclusively),
                increase its book copies with the provided number from the second line of the input.
            •	On the second line – the number of book copies each book should be increased with.
        Output:
            •	Total number of books that were added to the database.*/
    @Override
    public void updateBookCopiesWithAmount(String date, long copiesCount) {
        LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd MMM yyyy"));
        int updatedBooksCount = booksRepository.updateBookCopiesWithAmount(parsedDate, copiesCount);
        System.out.println(updatedBooksCount);
    }

    @Override
    public void deleteAndPrintCountOfBooksWithPriceLowerThan(Long copies) {
        int updateBooksCount = booksRepository.deleteByCopiesLessThan(copies);
        System.out.println(updateBooksCount);
    }
}
