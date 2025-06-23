package E01_Bookshop_System.services;

import E01_Bookshop_System.entities.*;
import E01_Bookshop_System.repositories.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final String AUTHORS_FILE_PATH = "06_Spring_Data/05_Spring_Data_Introduction/E01_Bookshop_System/src/main/resources/files/authors.txt";
    private final AuthorRepository authorsRepository;

    public AuthorServiceImpl(AuthorRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        Set<Author> authors = new HashSet<>();
        for (String line : Files.readAllLines(Path.of(AUTHORS_FILE_PATH))) {
            String formattedLine = line.trim();
            if (!formattedLine.isBlank()) {
                String[] authorNames = formattedLine.split("\\s+");
                Author author = new Author(authorNames[0], authorNames[1]);
                /*if (!authors.contains(author)) {
                    authors.add(author);
                }*/
                authors.add(author);
            }
        }
        authorsRepository.saveAll(authors);
    }
}
