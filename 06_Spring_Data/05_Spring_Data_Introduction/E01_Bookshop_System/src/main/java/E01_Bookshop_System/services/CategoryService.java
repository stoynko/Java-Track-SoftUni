package E01_Bookshop_System.services;

import E01_Bookshop_System.entities.*;

import java.io.*;

public interface CategoryService {

    Iterable<Category> getRandomCategories();
    boolean areCategoriesImported();
    void seedCategories() throws IOException;
}
