package E01_Products_Shop.service;

import E01_Products_Shop.data.*;

import java.util.*;

public interface CategoryService {

    Set<Category> getRandomCategories();

    void importDataWithJackson();

    void importDataWithGSON();

    boolean isImported();

    void exportCategoriesInfo();
}