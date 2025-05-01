package D_Java_OOP.X_Workshop.entities.user;

import D_Java_OOP.X_Workshop.common.*;

import java.util.*;

public class User {

    private String username;
    private String password;
    private UUID id;

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
        this.id = UUID.randomUUID();
    }

    public String getUsername() {
        return username;
    }

    void setUsername(String username) {
        UserValidator.validateUsername(username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        UserValidator.validatePassword(password);
        this.password = password;
    }

    public UUID getId() {
        return id;
    }
}
