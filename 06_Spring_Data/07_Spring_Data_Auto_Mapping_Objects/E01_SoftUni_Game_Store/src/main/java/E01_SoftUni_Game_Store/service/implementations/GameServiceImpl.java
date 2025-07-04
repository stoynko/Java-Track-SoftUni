package E01_SoftUni_Game_Store.service.implementations;

import E01_SoftUni_Game_Store.data.common.*;
import E01_SoftUni_Game_Store.data.entities.*;
import E01_SoftUni_Game_Store.data.repositories.*;
import E01_SoftUni_Game_Store.service.*;
import E01_SoftUni_Game_Store.service.dto.*;
import E01_SoftUni_Game_Store.service.utilities.*;
import jakarta.validation.*;
import org.modelmapper.*;
import org.springframework.stereotype.*;

import java.util.stream.*;

@Service
public class GameServiceImpl implements GameService {

    private GamesRepository gamesRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validator;

    public GameServiceImpl(GamesRepository gamesRepository, ModelMapper modelMapper, ValidatorUtil validator) {
        this.gamesRepository = gamesRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public String addGame(CreateGameDTO gameCreationDTO) {

        if (!this.validator.isValid(gameCreationDTO)) {
            return validator.validate(gameCreationDTO)
                            .stream().map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining(" | "));
        }

        Game game = this.modelMapper.map(gameCreationDTO, Game.class);
        this.gamesRepository.saveAndFlush(game);
        return String.format(ConsoleLogMessage.ADDED_GAME, game.getTitle());
    }

    @Override
    public String editGame(EditGameDTO gameEditDTO) {
        return "";
    }

    @Override
    public String deleteGame() {
        return "";
    }

    @Override
    public boolean gameExists(Game game) {
        return this.gamesRepository.findById(game.getId()).isPresent();
    }
}
