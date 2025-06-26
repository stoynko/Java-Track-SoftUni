package E01_Bookshop.services;

import E01_Bookshop.entities.*;

import java.io.*;

public interface CategoryService {

    Iterable<Category> getRandomCategories();
    boolean areCategoriesImported();
    void seedCategories() throws IOException;
}
