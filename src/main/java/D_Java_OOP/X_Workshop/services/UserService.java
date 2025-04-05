package D_Java_OOP.X_Workshop.services;

import D_Java_OOP.X_Workshop.entities.user.User;

import java.util.List;

public interface UserService {

    String login(String username, String password);

    String register(String username, String password);

    String logout();

    List<User> getAllUsers();

}
