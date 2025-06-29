package E01_Bookshop.services;

import E01_Bookshop.entities.*;

import java.io.*;
import java.time.*;

public interface AuthorService {

    boolean areAuthorsImported();
    void seedAuthors() throws IOException;
    Author getRandomAuthor();
    void printAuthorsByBooksReleasedBefore(LocalDate date);
    void printAuthorsByBookCountDescending();
    void findByFirstNameIsEndingWith(String param);
    void findByBookCopiesCount();
}
