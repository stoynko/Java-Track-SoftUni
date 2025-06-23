package E01_Bookshop_System.services;

import E01_Bookshop_System.entities.*;

import java.io.*;

public interface AuthorService {

    boolean areAuthorsImported();
    void seedAuthors() throws IOException;
    Author getRandomAuthor();
}
