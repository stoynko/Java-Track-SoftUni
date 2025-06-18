package L02_Models.services;

import L02_Models.entities.*;
import L02_Models.repositories.*;
import jakarta.persistence.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void addAccount(User user, Account account) {
        if (userRepository.existsById(user.getId())) {
            user.setAccounts(List.of(account));
            account.setUser(user);
            userRepository.save(user);
        }
    }
}
