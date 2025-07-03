package E01_SoftUni_Game_Store.controller;

import E01_SoftUni_Game_Store.service.*;
import E01_SoftUni_Game_Store.service.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.sql.*;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final UserService userService;

    @Autowired
    public CommandLineRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        init();

        while(!"4".equals(input = reader.readLine())) {

            switch (input) {
                case "1" -> {
                    String[] inputData = reader.readLine().split("\\|");
                    registerUser(inputData);
                }
                case "2" -> {
                    String[] inputData = reader.readLine().split("\\|");
                    loginUser(inputData);
                }
                case "3" -> {
                    logoutUser();
                }
                default -> {
                    System.out.println("Invalid input.");
                }
            }


        }
    }

    private void logoutUser() {
        System.out.println(this.userService.logoutUser());
    }

    private void loginUser(String[] inputData) {
        String email = inputData[1];
        String password = inputData[2];
        LoginUserDTO userDTO = new LoginUserDTO(email, password);
        System.out.println(this.userService.loginUser(userDTO));
    }

    private void registerUser(String[] inputData) {
        String email = inputData[1];
        String password = inputData[2];
        String passwordConfirmation = inputData[3];
        String fullName = inputData[4];
        CreateUserDTO userDTO = new CreateUserDTO(email, password, passwordConfirmation, fullName);
        System.out.println(this.userService.registerUser(userDTO));
    }

    public void init() {
        StringBuilder output = new StringBuilder();
        output.append("1. Register").append(System.lineSeparator());
        output.append("2. Login").append(System.lineSeparator());
        output.append("3. Logout").append(System.lineSeparator());
        output.append("4. Terminate").append(System.lineSeparator());
        System.out.println(output);
    }
}
