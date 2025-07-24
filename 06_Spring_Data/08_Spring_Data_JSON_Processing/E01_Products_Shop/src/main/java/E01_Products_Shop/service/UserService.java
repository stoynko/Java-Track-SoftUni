package E01_Products_Shop.service;

import E01_Products_Shop.data.*;

import java.util.*;

public interface UserService {

    void importDataWithJackson();
    void importDataWithGSON();
    boolean isImported();
    User getRandomUser();
    Set<User> getRandomFriends();
    void exportUsersWithSoldProducts();
    void exportUsersWithListedProducts();
}
