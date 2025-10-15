package main.web.resolver;

import main.model.Item;
import main.model.Player;
import main.model.PlayerRole;
import main.service.ItemService;
import main.service.PlayerService;
import main.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class QuestMasterHomeResolver implements HomeResolver {


    private final PlayerService playerService;
    private final QuestService questService;
    private final ItemService itemService;

    @Autowired
    public QuestMasterHomeResolver(PlayerService playerService, QuestService questService, ItemService itemService) {
        this.playerService = playerService;
        this.questService = questService;
        this.itemService = itemService;
    }

    @Override
    public boolean supports(PlayerRole playerRole) {
        return playerRole == PlayerRole.QUEST_MASTER;
    }

    @Override
    public String getViewName() {
        return "quest-master-home";
    }

    @Override
    public Map<String, Object> getModelData(Player player) {

        List<Player> allAdventurers = playerService.getAllAdventurers();
        List<Item> allItems = itemService.getAllItems();

        return Map.of(
                "totalAdventurers", allAdventurers.size(),
                "totalQuests", questService.getAllQuests().size(),
                "totalItems", itemService.getAllItems().size(),
                "allAdventurers", allAdventurers
        );
    }
}
