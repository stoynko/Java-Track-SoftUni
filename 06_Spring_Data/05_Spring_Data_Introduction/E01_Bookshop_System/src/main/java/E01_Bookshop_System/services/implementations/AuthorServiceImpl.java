package E01_Bookshop_System.services.implementations;

import E01_Bookshop_System.entities.*;
import E01_Bookshop_System.repositories.*;
import E01_Bookshop_System.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

@Service
public class AuthorServiceImpl implements AuthorService {

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
        Random random = new Random();
        long randomNumber = random.nextLong(authorsRepository.count() + 1);
        //TODO
        return null;
    }
}
