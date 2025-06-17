package X_Workshop.services.imp;

import D_Java_OOP.X_Workshop.common.*;
import D_Java_OOP.X_Workshop.core.*;
import X_Workshop.entities.user.User;
import D_Java_OOP.X_Workshop.repositories.*;
import X_Workshop.services.UserService;

import java.util.*;

public class UserServiceImpl implements UserService {

    private UserSessionManager sessionManager;
    private UserRepository userRepository;

    public UserServiceImpl(UserSessionManager sessionManager) {
        this.sessionManager = sessionManager;
        this.userRepository = new UserRepository();
    }

    @Override
    public String login(String username, String password) {

        if (sessionManager.hasActiveSession()) {
            String currentLoggedUsername = sessionManager.getActiveSession().getUsername();
            throw new IllegalStateException(SystemErrors.USER_ALREADY_LOGGED_IN.formatted(currentLoggedUsername));
        }
        User user = userRepository.getAll().stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(SystemErrors.INCORRECT_LOGIN_CREDENTIALS));

        sessionManager.setActiveSession(user);
        return LogMessages.SUCCESSFULLY_LOGGED_IN.formatted(user.getUsername());
    }

    @Override
    public String register(String username, String password) {
        if (userRepository.getAll().stream().anyMatch(u -> u.getUsername().equals(username))) {
            throw new IllegalArgumentException(SystemErrors.SUCH_USERNAME_ALREADY_EXIST.formatted(username));
        }
        User user = new User(username, password);
        userRepository.save(user.getId(), user);
        return LogMessages.SUCCESSFULLY_REGISTERED.formatted(username);
    }

    @Override
    public String logout() {
        String currentLoggedUsername;
        if (sessionManager.hasActiveSession()) {
            currentLoggedUsername = sessionManager.getActiveSession().getUsername();
            sessionManager.terminateActiveSession();
        } else {
            throw new IllegalStateException(SystemErrors.NO_ACTIVE_USER_SESSION_FOUND);
        }
        return LogMessages.SUCCESSFULLY_LOGGED_OUT.formatted(currentLoggedUsername);
    }

    @Override
    public List<User> getAllUsers() {
        return Collections.unmodifiableList(userRepository.getAll());
    }
}
