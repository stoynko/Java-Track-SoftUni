package E01_SoftUni_Game_Store.data.common;

public class ConsoleLogMessage {

    public static final String MAIN_MENU = """
                                            1. Register
                                            2. Login
                                            3. Logout
                                            4. Terminate
                                            """;
    public static final String MAIN_MENU_ADMIN = """
                                                1. Add Game
                                                2. Edit Game
                                                3. Delete Game
                                                4. Logout
                                                """;

    public static final String MAIN_MENU_USER = """
                                               1. Add Item
                                               2. Remove Item
                                               3. Buy Item
                                               4. Logout
                                               """;

    public static final String REGISTRATION_SUCCESSFULL = "User %s was registered successfully!";
    public static final String LOGIN_SUCCESSFULL = "Successfully logged in user %s";
    public static final String LOGOUT_SUCCESSFULL = "User %s was successfully logged out";
}
