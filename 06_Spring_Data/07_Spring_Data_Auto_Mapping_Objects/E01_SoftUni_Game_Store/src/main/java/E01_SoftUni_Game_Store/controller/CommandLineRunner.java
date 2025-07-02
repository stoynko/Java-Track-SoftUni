package E01_SoftUni_Game_Store.controller;

import E01_SoftUni_Game_Store.service.*;
import E01_SoftUni_Game_Store.service.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;

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

        while(!"3".equals(input = reader.readLine())) {

            switch (input) {
                case "1" -> {
                    String[] inputData = reader.readLine().split("\\|");
                    registerUser(inputData);
                }
                case "2" -> {
                    //String email = inputData[1];
                    //String password = inputData[2];
                    //loginUser(email, password);
                }
                default -> {
                    System.out.println("Invalid input.");
                }
            }


        }
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
        output.append("3. Terminate").append(System.lineSeparator());
        System.out.println(output);
    }
}
