package main.web.resolver;

import jakarta.servlet.http.HttpSession;
import main.model.Item;
import main.model.Player;
import main.model.PlayerRole;
import main.model.Quest;
import main.service.PlayerService;
import main.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AdventurerHomeResolver implements HomeResolver {

    private final PlayerService playerService;
    private final QuestService questService;

    @Autowired
    public AdventurerHomeResolver(PlayerService playerService, HttpSession session, QuestService questService) {
        this.playerService = playerService;
        this.questService = questService;
    }


    @Override
    public boolean supports(PlayerRole playerRole) {
        return playerRole == PlayerRole.ADVENTURER;
    }

    @Override
    public String getViewName() {
        return "adventurer-home";
    }

    @Override
    public Map<String, Object> getModelData(Player player) {

        List<Quest> eligibleQuests = questService.findEligibleQuests(player.getPlayerClass());
        List<Quest> capturedQuests = eligibleQuests.stream()
                .filter(quest -> quest.getCapturer() != null).toList();

        return Map.of(
                "eligibleQuests", eligibleQuests,
                "capturedQuests", capturedQuests
        );
    }
}
