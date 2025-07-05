package E01_SoftUni_Game_Store.controller;

import E01_SoftUni_Game_Store.data.common.*;
import E01_SoftUni_Game_Store.data.entities.*;
import E01_SoftUni_Game_Store.data.repositories.*;
import E01_SoftUni_Game_Store.service.*;
import E01_SoftUni_Game_Store.service.dto.*;
import E01_SoftUni_Game_Store.service.implementations.*;
import E01_SoftUni_Game_Store.service.utilities.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.math.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

import static java.time.format.DateTimeFormatter.ofPattern;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final UserService userService;
    private final GameService gamesService;
    private final UserSessionManager userSessionManager;
    private final BufferedReader reader;
    private final SessionManager sessionManager;
    private final ApplicationUtil applicatinUtil;
    private final GamesRepository gamesRepository;

    @Autowired
    public CommandLineRunner(UserService userService, GameService gamesService, UserSessionManager userSessionManager, BufferedReader reader, SessionManager sessionManager, ApplicationUtil applicatinUtil, GamesRepository gamesRepository) {
        this.userSessionManager = userSessionManager;
        this.userService = userService;
        this.gamesService = gamesService;
        this.reader = reader;
        this.sessionManager = sessionManager;
        this.applicatinUtil = applicatinUtil;
        this.gamesRepository = gamesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            displayMenu();
            //yani@email.com|Yani123|Yani123|Yani
            //yani@email.com|Yani123|Yani123
            //pesho@pesho.com|Pep123|Pep123|Pesho
            //Overwatch|100.00|15.5|FqnKB22pOC0|https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|Overwatch is a team-based multiplayer online first-person shooter video game developed and published by Blizzard Entertainment.|24-05-2016
        }
    }

    private void displayMenu() throws IOException {
        if (sessionManager.hasActiveSession()) {
            if (userSessionManager.getActiveSession().isAdmin()) {
                System.out.print(ConsoleLogMessage.MAIN_MENU_ADMIN);
                adminMenuListener(reader.readLine());
            } else {
                System.out.print(ConsoleLogMessage.MAIN_MENU_USER);
                userMenuListener(reader.readLine());
            }
        } else {
            System.out.print(ConsoleLogMessage.MAIN_MENU);
            mainMenuListener(reader.readLine());
        }
    }

    private void userMenuListener(String input) throws IOException {

        while (true) {
            if ("add item".equals(input.toLowerCase()) || "1".equals(input)) {
                try {
                    //TODO Implement addItem()
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("remove item".equals(input.toLowerCase()) || "2".equals(input)) {
                try {
                    //TODO Implement removeItem()
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("buy item".equals(input.toLowerCase()) || "3".equals(input)) {
                try {
                    //TODO Implement buyItem()
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("logout".equals(input.toLowerCase()) || "4".equals(input)) {
                logoutUser();
                return;
            } else if ("exit".equals(input.toLowerCase()) || "5".equals(input)) {
                applicatinUtil.shutdown();
            } else {
                System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
            }

            input = reader.readLine();
        }
    }

    private void adminMenuListener(String input) throws IOException {

        while (true) {
            if ("add game".equals(input.toLowerCase()) || "1".equals(input)) {
                List<String> inputData = processInputData(reader);
                try {
                    addGame(inputData);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("edit game".equals(input.toLowerCase()) || "2".equals(input)) {
                try {
                    //TODO Implement editGame()
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("delete game".equals(input.toLowerCase()) || "3".equals(input)) {
                try {
                    //TODO Implement deleteGame()
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("logout".equals(input.toLowerCase()) || "4".equals(input)) {
                logoutUser();
                return;
            } else if ("exit".equals(input.toLowerCase()) || "5".equals(input)) {
                applicatinUtil.shutdown();
            } else {
                System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
            }

            input = reader.readLine();
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
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("login".equals(input.toLowerCase()) || "2".equals(input)) {
                System.out.println(ConsoleLogMessage.LOGIN_REQUIRED_INFO);
                List<String> inputData = processInputData(reader);
                try {
                    loginUser(inputData);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("logout".equals(input.toLowerCase()) || "3".equals(input)) {
                logoutUser();
                return;
            } else if ("exit".equals(input.toLowerCase()) || "4".equals(input)) {
                applicatinUtil.shutdown();
            } else {
                System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                return;
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

    private void addGame(List<String> inputData) {
        String title = inputData.get(0);
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(inputData.get(1)));
        Double size = Double.parseDouble(inputData.get(2));
        String trailerURL = inputData.get(3);
        String thumbnailURL = inputData.get(4);
        String description = inputData.get(5);
        LocalDate releaseDate = LocalDate.parse(inputData.get(6), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        CreateGameDTO gameDTO = new CreateGameDTO(title, price, size, trailerURL, thumbnailURL, description, releaseDate);
        System.out.println(gamesService.addGame(gameDTO));
    }
}