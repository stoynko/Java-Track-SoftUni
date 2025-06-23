package E01_Bookshop_System.services;

import E01_Bookshop_System.entities.*;
import E01_Bookshop_System.repositories.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    private final String BOOKS_FILE_PATH = "06_Spring_Data/05_Spring_Data_Introduction/E01_Bookshop_System/src/main/resources/files/books.txt";
    private BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedBooks() throws IOException {

        Set<Book> books = new HashSet<>();
        for (String line : Files.readAllLines(Path.of(BOOKS_FILE_PATH))) {

        }
    }
}
