package E01_Bookshop.services;


import java.io.*;
import java.time.*;

public interface BookService {

    boolean areBooksImported();
    void seedBooks() throws IOException;
    void printAllBooksAfter(LocalDate date);
    void printAllBooksBy(String firstName, String lastName);
}
