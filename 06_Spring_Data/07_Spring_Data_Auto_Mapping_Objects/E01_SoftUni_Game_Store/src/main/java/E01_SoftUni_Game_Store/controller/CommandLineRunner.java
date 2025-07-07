package E01_SoftUni_Game_Store.controller;

import E01_SoftUni_Game_Store.data.common.*;
import E01_SoftUni_Game_Store.data.repositories.*;
import E01_SoftUni_Game_Store.service.*;
import E01_SoftUni_Game_Store.service.dto.*;
import E01_SoftUni_Game_Store.service.implementations.*;
import E01_SoftUni_Game_Store.service.utilities.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.math.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final UserService userService;
    private final GameService gamesService;
    private final UserSessionManager userSessionManager;
    private final BufferedReader reader;
    private final SessionManager sessionManager;
    private final ApplicationUtil applicationUtil;
    private final GamesRepository gamesRepository;

    @Autowired
    public CommandLineRunner(UserService userService, GameService gamesService, UserSessionManager userSessionManager, BufferedReader reader, SessionManager sessionManager, ApplicationUtil applicationUtil, GamesRepository gamesRepository) {
        this.userSessionManager = userSessionManager;
        this.userService = userService;
        this.gamesService = gamesService;
        this.reader = reader;
        this.sessionManager = sessionManager;
        this.applicationUtil = applicationUtil;
        this.gamesRepository = gamesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            displayMenu();
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
            } else if ("all games".equals(input.toLowerCase()) || "4".equals(input)) {
                try {
                    gamesService.displayAllGames().stream().forEach(game -> {
                        System.out.printf("%s - %.2f\n", game.getTitle(), game.getPrice());
                    });
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("game details".equals(input.toLowerCase()) || "5".equals(input)) {
                String title = reader.readLine();
                try {
                    GameDetailedViewDTO game = gamesService.displayGameDetails(title);
                    System.out.println(displayGameDetails(game, title));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                } catch (NullPointerException n) {
                    System.out.println(String.format(SystemErrorMessage.GAME_TITLE_NON_EXISTENT, title));
                }
                return;
            } else if ("owned games".equals(input.toLowerCase()) || "6".equals(input)) {
                try {
                    Set<GameOwnedDTO> ownedGames = gamesService.displayOwnedGames();
                    if (ownedGames.isEmpty()) {
                        System.out.println(String.format(SystemErrorMessage.USER_NO_OWNED_GAMES, userSessionManager.getActiveSession().getFullName()));
                    } else {
                        System.out.println(String.format(ConsoleLogMessage.GAME_OWNER_BY_USER, userSessionManager.getActiveSession().getFullName()));
                        ownedGames.forEach(game -> System.out.println(game.getTitle()));
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("logout".equals(input.toLowerCase()) || "7".equals(input)) {
                logoutUser();
                return;
            } else if ("exit".equals(input.toLowerCase()) || "8".equals(input)) {
                applicationUtil.shutdown();
            } else {
                System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
            }

            input = reader.readLine();
        }
    }

        private String displayGameDetails(GameDetailedViewDTO game, String title) {
            if (game == null) {
                return String.format(SystemErrorMessage.GAME_TITLE_NON_EXISTENT, title);
            }
            StringBuilder output = new StringBuilder();
            output.append(String.format("Title: %s", game.getTitle())).append(System.lineSeparator());
            output.append(String.format("Price: %.2f", game.getPrice())).append(System.lineSeparator());
            output.append(String.format("Description: %s", game.getDescription())).append(System.lineSeparator());
            output.append(String.format("Release date: %02d.%02d.%d", game.getReleaseDate().getDayOfMonth(),
                    game.getReleaseDate().getMonthValue(),
                    game.getReleaseDate().getYear())).append(System.lineSeparator());
            return output.toString();
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
                    List<String> inputData = processInputData(reader);
                    try {
                        editGame(inputData);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                    }
                    return;
                } else if ("delete game".equals(input.toLowerCase()) || "3".equals(input)) {
                    Long gameID = Long.parseLong(reader.readLine());
                    try {
                        deleteGame(gameID);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                    }
                    return;
                } else if ("logout".equals(input.toLowerCase()) || "4".equals(input)) {
                    logoutUser();
                    return;
                } else if ("exit".equals(input.toLowerCase()) || "5".equals(input)) {
                    applicationUtil.shutdown();
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
                    applicationUtil.shutdown();
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

        private void editGame(List<String> inputData) {
            long gameID = Long.parseLong(inputData.get(0));
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(inputData.get(1)));
            double size = Double.parseDouble(inputData.get(2));
            EditGameDTO editDTO = new EditGameDTO(gameID, price, size);
            System.out.println(gamesService.editGame(editDTO));
        }

        private void deleteGame(Long gameID) {
            System.out.println(gamesService.deleteGame(gameID));
        }
    }
