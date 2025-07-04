package E01_SoftUni_Game_Store.controller;

import E01_SoftUni_Game_Store.data.common.*;
import E01_SoftUni_Game_Store.data.entities.*;
import E01_SoftUni_Game_Store.service.*;
import E01_SoftUni_Game_Store.service.dto.*;
import E01_SoftUni_Game_Store.service.implementations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final UserService userService;
    private final UserSessionManager userSessionManager;
    private final BufferedReader reader;
    private final SessionManager sessionManager;
    private final ApplicationUtilImpl applicationUtilImpl;

    @Autowired
    public CommandLineRunner(UserService userService, UserSessionManager userSessionManager, BufferedReader reader, SessionManager sessionManager, ApplicationUtilImpl applicationUtilImpl) {
        this.userSessionManager = userSessionManager;
        this.userService = userService;
        this.reader = reader;
        this.sessionManager = sessionManager;
        this.applicationUtilImpl = applicationUtilImpl;
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            displayMenu();
            //yani@email.com|Yani123|Yani123|Yani
        }
    }

    private void displayMenu() throws IOException {
        if (sessionManager.hasActiveSession()) {
            if (userSessionManager.getActiveSession().isAdmin()) {
                System.out.print(ConsoleLogMessage.MAIN_MENU_ADMIN);
                //adminMenuListener(reader.readLine());
            } else {
                System.out.print(ConsoleLogMessage.MAIN_MENU_USER);
                //userMenuListener(reader.readLine());
            }
        } else {
            System.out.print(ConsoleLogMessage.MAIN_MENU);
            mainMenuListener(reader.readLine());
        }
    }

    private void mainMenuListener(String input) throws IOException {
        while (true) {
            if ("register".equals(input.toLowerCase()) || "1".equals(input)) {
                System.out.println(ConsoleLogMessage.REGISTRATION_REQUIRED_INFO);
                List<String> inputData = processInputData(reader);
                try {
                    registerUser(inputData);
                    loginUser(inputData);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
            } else if ("login".equals(input.toLowerCase()) || "2".equals(input)) {
                System.out.println(ConsoleLogMessage.LOGIN_REQUIRED_INFO);
                List<String> inputData = processInputData(reader);
                loginUser(inputData);
            } else if ("logout".equals(input.toLowerCase()) || "3".equals(input)) {
                logoutUser();
                return;
            } else if ("exit".equals(input.toLowerCase()) || "4".equals(input)) {
                applicationUtilImpl.shutdown();
            } else {
                System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
            }
            input = reader.readLine();
        }
    }

    private List<String> processInputData(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split("\\|"))
                                        .map(e -> e.trim())
                                        .collect(Collectors.toList());
    }

    private void registerUser(List<String> inputData) {
        String email = inputData.get(0);
        String password = inputData.get(1);
        String passwordConfirmation = inputData.get(2);
        String fullName = inputData.get(3);
        CreateUserDTO userDTO = new CreateUserDTO(email, password, passwordConfirmation, fullName);
        System.out.println(this.userService.registerUser(userDTO));
    }

    private void loginUser(List<String> inputData) {
        String email = inputData.get(0);
        String password = inputData.get(1);
        LoginUserDTO userDTO = new LoginUserDTO(email, password);
        System.out.println(this.userService.loginUser(userDTO));
    }

    private void logoutUser() {
        System.out.println(this.userService.logoutUser());
    }
}
