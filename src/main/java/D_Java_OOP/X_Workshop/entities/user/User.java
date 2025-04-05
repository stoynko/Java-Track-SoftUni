package D_Java_OOP.X_Workshop.entities.user;

import java.util.*;

public class User{


    private String username;
    private String password;
    private UUID id;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = UUID.randomUUID();
    }

    void setUsername(String username) {
        UserValidator.validateUsername(username);
        this.username = username;
    }

    void setPassword(String password) {
        UserValidator.validatePassword(password);
        this.password = password;
    }
}
