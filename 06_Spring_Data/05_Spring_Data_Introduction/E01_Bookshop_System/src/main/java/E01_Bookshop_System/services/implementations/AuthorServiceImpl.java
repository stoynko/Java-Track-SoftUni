package E01_Bookshop_System.services.implementations;

import E01_Bookshop_System.entities.*;
import E01_Bookshop_System.repositories.*;
import E01_Bookshop_System.services.*;
import jakarta.persistence.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);
    private final String AUTHORS_FILE_PATH = "06_Spring_Data/05_Spring_Data_Introduction/E01_Bookshop_System/src/main/resources/files/authors.txt";
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
    public void printDistinctAuthorsByBooksReleasedBefore(LocalDate date) {
        this.authorsRepository.findAll()
                .stream()
                .filter(author -> author.getPublishedBooks()
                        .stream()
                        .anyMatch(book -> book.getReleaseDate().isBefore(date)))
                .forEach(author -> System.out.printf("%s %s\n", author.getFirstName(), author.getLastName()));

    }
}