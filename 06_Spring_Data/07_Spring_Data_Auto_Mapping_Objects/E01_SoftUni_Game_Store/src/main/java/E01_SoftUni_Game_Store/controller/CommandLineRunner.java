package E01_SoftUni_Game_Store.controller;

import E01_SoftUni_Game_Store.data.common.*;
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

/*The game store is a platform, where users can buy games. Your task is to create a console application for the store.
    Data Models:
    Create the required entities. Use appropriate data types.
            • The system contains information about users and games.
            • Users can register in the system. After successful registration, the user has email, password, full name,
              list of games and information on whether he/she is an administrator or not.
            • The first registered user becomes also an administrator. You can manually mark users as admins in the database.
            • A game has a title, trailer (YouTube Video Id), image thumbnail (URL), size, price, description and release date
            • Users can make orders. Each order has a single buyer (user) and one or many products.
    Functionality:
        • All users can view all games.
        • All users can view the details of each game.
        • Logged-in users can logout.
        • Logged in users can add/remove games from their shopping cart.
        • Logged in users can buy games that are added to the shopping cart and those games are added to the profile of the user and cannot be bought for a second time.
        • Administrators can add, edit or delete games.
        • Basic user can not add, edit or delete game.

1.	Design the Database - Design entity classes and create a database to hold the users, games and orders.
2.	Implement User Registration, Login and Logout
    The guest users can register and log in.
        • RegisterUser|<email>|<password>|<confirmPassword>|<fullName> - This command adds a new user to the database in case of valid parameters.
            Otherwise, prints an appropriate message informing why the user cannot be registered. The requirements for valid parameters are:
            o	Email – must contain @ sign and a period. It must be unique.
            o	Password – length must be at least 6 symbols and must contain at least 1 uppercase, 1 lowercase letter and 1 digit.
            o	Confirm Password – must match the provided password.
        • LoginUser|<email>|<password> - This command sets the current logged in user if it exists. Otherwise, prints an appropriate message. Logged in user can logout.
        • Logout – This command logs out the user from the system. If there is no logged in user, print appropriate message.

As an admin, you have the option to add/edit/delete games to the catalog.
    • AddGame|<title>|<price>|<size>|<trailer>|<thubnailURL>|<description>|<releaseDate>
    • EditGame|<id>|<values> - A game should be edited in case of valid id. Otherwise, print the appropriate message.
      A game should be added/edited only to the catalog, if it matches the following criteria:
        o Title – has to begin with an uppercase letter and must have a length between 3 and 100 symbols (inclusively).
        o Price – must be a positive number.
        o Size – must be a positive number.
        o Trailer – only videos from YouTube are allowed. Only their ID, which is a string of exactly 11 characters, should be saved to the database.
    For example, if the URL to the trailer is https://www.youtube.com/watch?v=edYCtaNueQY, the required part that must be saved into the database is edYCtaNueQY.
    That would be always the last 11 characters from the provided URL.
        o Thumbnail URL – it should be plain text starting with http://, https://
        o Description – must be at least 20 symbols
    •	DeleteGame|<id> - A game should be deleted in case of valid id. Otherwise, print an appropriate message.

Implement a view for retrieving different information about the games.
    • AllGames - print titles and price of all games.
    • DetailsGame|<gameTitle> - print details for а single game.
    • OwnedGames – print the games bought by the currently logged in user.
        o First you have to make a game purchase method from a user.

Each user should be able to buy a game.
    • AddItem|<gameTitle> - add game to shopping cart
    • RemoveItem|<gameTitle> - remove game from shopping cart
    • BuyItem – buy all games from the shopping cart
        o A user can buy a game only once!
        o If he owns a game, he shouldn't be able to add it to the shopping cart. */

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final BufferedReader reader;
    private final UserService userService;
    private final GameService gamesService;
    private final UserSessionManager userSessionManager;
    private final SessionManager sessionManager;
    private final ApplicationUtil applicationUtil;

    public CommandLineRunner(BufferedReader reader, UserService userService, GameService gamesService, UserSessionManager userSessionManager, SessionManager sessionManager, ApplicationUtil applicationUtil) {
        this.reader = reader;
        this.userService = userService;
        this.gamesService = gamesService;
        this.userSessionManager = userSessionManager;
        this.sessionManager = sessionManager;
        this.applicationUtil = applicationUtil;
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
            if ("add item".equalsIgnoreCase(input) || "1".equals(input)) {
                String title = reader.readLine();
                try {
                    System.out.println(gamesService.addItemToBasket(title));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("remove item".equalsIgnoreCase(input) || "2".equals(input)) {
                String title = reader.readLine();
                try {
                    System.out.println(gamesService.removeItemFromBasket(title));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("buy item".equalsIgnoreCase(input) || "3".equals(input)) {
                try {
                    System.out.println(gamesService.buyItems());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("all games".equalsIgnoreCase(input) || "4".equals(input)) {
                try {
                    gamesService.displayAllGames().stream().forEach(game -> {
                        System.out.printf("%s - %.2f\n", game.getTitle(), game.getPrice());
                    });
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("game details".equalsIgnoreCase(input) || "5".equals(input)) {
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
            } else if ("owned games".equalsIgnoreCase(input) || "6".equals(input)) {
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
            } else if ("logout".equalsIgnoreCase(input) || "7".equals(input)) {
                logoutUser();
                return;
            } else if ("exit".equalsIgnoreCase(input) || "8".equals(input)) {
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

    private void mainMenuListener(String input) throws IOException {
        while (true) {
            if ("register".equalsIgnoreCase(input) || "1".equals(input)) {
                System.out.println(ConsoleLogMessage.REGISTRATION_REQUIRED_INFO);
                List<String> inputData = processInputData(reader);
                try {
                    registerUser(inputData);
                    loginUser(inputData);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("login".equalsIgnoreCase(input) || "2".equals(input)) {
                System.out.println(ConsoleLogMessage.LOGIN_REQUIRED_INFO);
                List<String> inputData = processInputData(reader);
                try {
                    loginUser(inputData);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                }
                return;
            } else if ("logout".equalsIgnoreCase(input) || "3".equals(input)) {
                logoutUser();
                return;
            } else if ("exit".equalsIgnoreCase(input) || "4".equals(input)) {
                applicationUtil.shutdown();
            } else {
                System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                return;
            }
            input = reader.readLine();
        }
    }
        private void adminMenuListener(String input) throws IOException {

            while (true) {
                if ("add game".equalsIgnoreCase(input) || "1".equals(input)) {
                    List<String> inputData = processInputData(reader);
                    try {
                        addGame(inputData);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                    }
                    return;
                } else if ("edit game".equalsIgnoreCase(input) || "2".equals(input)) {
                    List<String> inputData = processInputData(reader);
                    try {
                        editGame(inputData);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                    }
                    return;
                } else if ("delete game".equalsIgnoreCase(input) || "3".equals(input)) {
                    Long gameID = Long.parseLong(reader.readLine());
                    try {
                        deleteGame(gameID);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(SystemErrorMessage.INVALID_INPUT_DATA);
                    }
                    return;
                } else if ("logout".equalsIgnoreCase(input) || "4".equals(input)) {
                    logoutUser();
                    return;
                } else if ("exit".equalsIgnoreCase(input) || "5".equals(input)) {
                    applicationUtil.shutdown();
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
