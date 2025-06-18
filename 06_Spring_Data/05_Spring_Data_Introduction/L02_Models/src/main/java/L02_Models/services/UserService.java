package L02_Models.services;

import L02_Models.entities.*;
import org.springframework.stereotype.*;

public interface UserService {

    void registerUser(User user);
    User getUserById(long id);
    void addAccount(User user, Account account);
}
