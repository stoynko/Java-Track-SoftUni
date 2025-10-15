package main.config.mappers;

import main.model.Player;
import main.web.dto.RegisterRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    Player toPlayer(RegisterRequest registerRequest);
}
