package E01_Bookshop.services.implementations;

import E01_Bookshop.entities.*;
import E01_Bookshop.entities.enums.*;
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

    private final String BOOKS_FILE_PATH = "06_Spring_Data/05_Spring_Data_Introduction/E01_Bookshop_System/src/main/resources/files/books.txt";
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
}
