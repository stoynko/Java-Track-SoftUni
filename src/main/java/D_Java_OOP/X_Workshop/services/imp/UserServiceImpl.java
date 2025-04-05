package D_Java_OOP.X_Workshop.services.imp;

import D_Java_OOP.X_Workshop.entities.user.User;
import D_Java_OOP.X_Workshop.services.UserService;

import java.util.List;

// TODO:
// 1. Implement all methods
// 2. Make sure this service implementation has dependency a SessionManager
// so you can determine which is the currently logged in user.
public class UserServiceImpl implements UserService {



    @Override
    public String login(String username, String password) {
        return "";
    }

    @Override
    public String register(String username, String password) {
        return "";
    }

    @Override
    public String logout() {
        return "";
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
