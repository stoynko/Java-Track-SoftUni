package E01_Bookshop_System.services;


import java.io.*;

public interface BookService {

    boolean areBooksImported();
    void seedBooks() throws IOException;
}
