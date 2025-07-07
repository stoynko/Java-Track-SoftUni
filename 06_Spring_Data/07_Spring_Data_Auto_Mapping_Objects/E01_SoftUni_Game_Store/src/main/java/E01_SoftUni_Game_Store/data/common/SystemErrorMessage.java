package E01_SoftUni_Game_Store.data.common;

public class SystemErrorMessage {

    public static final String REGISTRATION_EMAIL_EXISTS = "User with this email already exists.";
    public static final String REGISTRATION_PASSWORD_MISMATCH = "User with this email already exists.";
    public static final String LOGIN_INCORRECT_DATA = "Invalid email and/or password.";
    public static final String LOGOUT_NO_ACTIVE_SESSION = "Cannot log out. No user is logged in.";
    public static final String INVALID_INPUT_DATA = "Invalid input";
    public static final String INVALID_GAME_TITLE = "The game title has to start with an uppercase letter.";
    public static final String INVALID_GAME_URL = "The URL should start with an http or https protocol.";
    public static final String GAME_WITH_TITLE_EXISTS = "Game with title %s already exists in the catalog.";
    public static final String GAME_ID_NON_EXISTENT = "Game with an id of %d does not exist in the catalog";
    public static final String GAME_TITLE_NON_EXISTENT = "Game with title %s does not exist in the catalog";
    public static final String USER_NO_OWNED_GAMES = "User %s does not own any games.";
    public static final String GAME_NOT_IN_BASKET = "%s is not in your shopping basket.";
    public static final String UNEXPECTED_ERROR = "Unexpected error has occurred.";
}
