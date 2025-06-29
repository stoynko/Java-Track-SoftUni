package E01_Bookshop.services.implementations;

import E01_Bookshop.entities.*;
import E01_Bookshop.repositories.*;
import E01_Bookshop.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final String AUTHORS_FILE_PATH = "06_Spring_Data/06_Spring_Data_Advanced_Querying/E01_Bookshop/src/main/resources/files/authors.txt";
    private final AuthorRepository authorsRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @Override
    public boolean areAuthorsImported() {
        return authorsRepository.count() > 0;
    }

    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(AUTHORS_FILE_PATH)).forEach(line -> {
            String formattedLine = line.trim();
            if (!formattedLine.isBlank()) {
                String[] authorNames = formattedLine.split("\\s+");
                authorsRepository.saveAndFlush(new Author(authorNames[0], authorNames[1]));
            }
        });
    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom.current().nextLong(1, this.authorsRepository.count() + 1);
        return this.authorsRepository.findById(randomId).get();
    }

    @Override
    public void printAuthorsByBooksReleasedBefore(LocalDate date) {
        this.authorsRepository.findAll()
                .stream()
                .filter(author -> author.getPublishedBooks()
                        .stream()
                        .anyMatch(book -> book.getReleaseDate().isBefore(date)))
                .forEach(author -> System.out.printf("%s %s\n", author.getFirstName(), author.getLastName()));
    }

    @Override
    public void printAuthorsByBookCountDescending() {
        this.authorsRepository.findAllByOrderByPublishedBooksCountDesc().forEach(author -> {
            System.out.printf("%s %s - %d\n", author.getFirstName(), author.getLastName(), author.getPublishedBooks().stream().count());
        });

        /*this.authorsRepository.findAll().stream().sorted((a,b) ->
            b.getPublishedBooks().size() > a.getPublishedBooks().size() ? 1 : -1).forEach(author -> {
            System.out.printf("%s %s - %d\n", author.getFirstName(), author.getLastName(),
                                            author.getPublishedBooks().size());
        });*/
    }

    //E06. Write a program that prints the names of those authors, whose first name ends with a given string.
    public void findByFirstNameIsEndingWith(String param) {
        Set<Author> authorSet = this.authorsRepository.findByFirstNameIsEndingWith(param);
        authorSet.forEach(author -> {
            String fullName = author.getFirstName() + " " + author.getLastName();
            System.out.println(fullName);
        });
    }

    //E10. Write a program that prints the total number of book copies by author. Order the results descending by total book copies.
    public void findByBookCopiesCount() {
        authorsRepository.findAll().stream()
                         .sorted(Comparator.comparingInt((Author author) -> author.getPublishedBooks().stream()
                            .mapToInt(Book::getCopies).sum()).reversed())
                         .forEach(author -> {
                             System.out.printf("%s %s - %d\n", author.getFirstName(),
                             author.getLastName(),
                             author.getPublishedBooks().stream().mapToInt(Book::getCopies).sum());
        });
    }
}