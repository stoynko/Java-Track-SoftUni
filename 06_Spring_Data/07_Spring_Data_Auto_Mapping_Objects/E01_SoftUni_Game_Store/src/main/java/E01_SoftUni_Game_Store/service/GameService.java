package E01_SoftUni_Game_Store.service;

import E01_SoftUni_Game_Store.data.entities.*;
import E01_SoftUni_Game_Store.service.dto.*;

import java.math.*;

public interface GameService {

    String addGame(CreateGameDTO gameCreationDTO);
    String editGame(EditGameDTO gameEditDTO);
    String deleteGame(Long gameID);
    boolean gameExists(Game game);
}
