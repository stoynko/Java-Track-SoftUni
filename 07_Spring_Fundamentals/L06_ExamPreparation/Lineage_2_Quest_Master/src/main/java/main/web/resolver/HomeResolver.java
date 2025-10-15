package main.web.resolver;

import main.model.Player;
import main.model.PlayerRole;

import java.util.Map;

public interface HomeResolver {

    boolean supports(PlayerRole playerRole);

    String getViewName();

    Map<String, Object> getModelData(Player player);
}
