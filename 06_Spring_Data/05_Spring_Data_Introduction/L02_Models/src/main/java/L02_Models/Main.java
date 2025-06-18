package L02_Models;

import L02_Models.entities.*;
import L02_Models.repositories.*;
import L02_Models.services.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;

@Component
public class Main implements CommandLineRunner {

    private final UserService userService;
    private final UserRepository userRepository;

    public Main(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DB RUNNING!");

        /*Account accountA = new Account(BigDecimal.valueOf(100));
        Account accountB = new Account(BigDecimal.valueOf(250));
        Account accountC = new Account(BigDecimal.valueOf(1000));
        Account accountD = new Account(BigDecimal.valueOf(350));

        User userA = new User("Pesho", 25, List.of(accountA, accountB));
        User userB = new User("Gosho", 30, List.of(accountC, accountD));

        userService.registerUser(userA);
        userService.registerUser(userB);
        userService.addAccount(userA, accountA);
        userService.addAccount(userA, accountB);
        userService.addAccount(userB, accountC);
        userService.addAccount(userB, accountD);*/
        System.out.println(userRepository.findUsersByUsername("Gosho"));

    }
}
