package E01_SoftUni_Game_Store.service.implementations;

import E01_SoftUni_Game_Store.data.common.*;
import E01_SoftUni_Game_Store.data.entities.*;
import E01_SoftUni_Game_Store.data.repositories.*;
import E01_SoftUni_Game_Store.service.*;
import E01_SoftUni_Game_Store.service.dto.*;
import E01_SoftUni_Game_Store.service.utilities.*;
import org.modelmapper.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;
import java.util.stream.*;

@Service
public class GameServiceImpl implements GameService {

    private GamesRepository gamesRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validator;
    private final UserSessionManager userSessionManager;
    private final UserService userService;

    public GameServiceImpl(GamesRepository gamesRepository, ModelMapper modelMapper, ValidatorUtil validator, UserSessionManager userSessionManager, UserService userService) {
        this.gamesRepository = gamesRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.userSessionManager = userSessionManager;
        this.userService = userService;
    }

    @Override
    public String addGame(CreateGameDTO gameCreationDTO) {

        if (!this.validator.isValid(gameCreationDTO)) {
            return validator.getViolations(gameCreationDTO);
        }

        Game game = this.modelMapper.map(gameCreationDTO, Game.class);

        if (this.gamesRepository.existsByTitle(game.getTitle())) {
            return String.format(SystemErrorMessage.GAME_WITH_TITLE_EXISTS, game.getTitle());
        }

        this.gamesRepository.saveAndFlush(game);
        return String.format(ConsoleLogMessage.GAME_ADDED, game.getTitle());
    }

    @Override
    public String editGame(EditGameDTO gameEditDTO) {

        if (!validator.isValid(gameEditDTO)) {
            return validator.getViolations(gameEditDTO);
        }

        if (!gamesRepository.existsById(gameEditDTO.getId())) {
            return String.format(SystemErrorMessage.GAME_ID_NON_EXISTENT);
        }

        Game game = gamesRepository.findById(gameEditDTO.getId());
        if (gameEditDTO.getPrice() != null) {
            game.setPrice(gameEditDTO.getPrice());
        }
        if (!(gameEditDTO.getSize() <= 0)) {
            game.setSize(gameEditDTO.getSize());
        }

        this.gamesRepository.saveAndFlush(game);
        return String.format(ConsoleLogMessage.GAME_EDITED, game.getTitle());
    }

    @Override
    @Transactional
    @Modifying
    public String deleteGame(Long gameID) {

        if (!gamesRepository.existsById(gameID)) {
            return String.format(SystemErrorMessage.GAME_ID_NON_EXISTENT);
        }

        Game game = gamesRepository.findById(gameID).get();
        gamesRepository.deleteGameById(gameID);

        return String.format(ConsoleLogMessage.GAME_DELETED, game.getTitle());
    }

    @Override
    public boolean gameExists(Game game) {
        return this.gamesRepository.existsById(game.getId());
    }

    @Override
    public Set<GameBasicViewDTO> displayAllGames() {
        return gamesRepository.findAll().stream()
                              .map(game -> modelMapper.map(game, GameBasicViewDTO.class))
                              .collect(Collectors.toSet());
    }

    @Override
    public GameDetailedViewDTO displayGameDetails(String title) {
        Game game = this.gamesRepository.findGameByTitle(title);
        if (game != null) {
            return modelMapper.map(game, GameDetailedViewDTO.class);
        } else {
            return new GameDetailedViewDTO();
        }
    }
    @Override
    public Set<GameOwnedDTO> displayOwnedGames(){
        return userSessionManager.getActiveSession().getGames().stream()
                                 .map(game -> modelMapper.map(game, GameOwnedDTO.class))
                                 .collect(Collectors.toSet());
    }
}
