package E01_SoftUni_Game_Store.data.common;

public class ConsoleLogMessage {

    public static final String MAIN_MENU = """
                                            1. Register
                                            2. Login
                                            ───────────────
                                            3. Logout
                                            4. Exit Application
                                            """;
    public static final String MAIN_MENU_ADMIN = """
                                                1. Add Game
                                                2. Edit Game
                                                3. Delete Game
                                                ───────────────
                                                4. Logout
                                                5. Exit Application
                                                """;

    public static final String MAIN_MENU_USER = """
                                               1. Add Item
                                               2. Remove Item
                                               3. Buy Item
                                               ───────────────
                                               4. Display Games Catalog
                                               5. Display Game Details
                                               6. Display Owned Games
                                               ───────────────
                                               7. Logout
                                               8. Exit Application
                                               """;
    public static final String REGISTRATION_REQUIRED_INFO = "> Email | Password | Password | Full Name";
    public static final String LOGIN_REQUIRED_INFO = "> Email | Password | Password";
    public static final String REGISTRATION_SUCCESSFULL = "User %s was registered successfully!";
    public static final String LOGIN_SUCCESSFULL = "Successfully logged in user %s";
    public static final String LOGOUT_SUCCESSFULL = "User %s was successfully logged out";
    public static final String GAME_ADDED = "%s was successfully added to the catalog.";
    public static final String GAME_EDITED = "Game with title %s has been updated.";
    public static final String GAME_DELETED = "Game with title %s has been deleted.";
    public static final String GAME_OWNER_BY_USER = "User %s owns the following games:";
}
