package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.Player;
import main.model.Quest;
import main.repository.PlayerRepository;
import main.service.ItemService;
import main.service.PlayerService;
import main.service.QuestService;
import main.web.dto.CreateQuestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/quests")
public class QuestController {

    private final PlayerRepository playerRepository;
    private final QuestService questService;
    private final ItemService itemService;
    private final PlayerService playerService;

    @Autowired
    public QuestController(PlayerRepository playerRepository, QuestService questService, ItemService itemService, PlayerService playerService) {
        this.playerRepository = playerRepository;
        this.itemService = itemService;
        this.questService = questService;
        this.playerService = playerService;
    }

    @GetMapping("/quests")
    public ModelAndView getQuestsPage(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("createQuestRequest", new CreateQuestRequest());
        modelAndView.setViewName("quests");
        return modelAndView;
    }

    @PostMapping("/quests")
    public ModelAndView createQuest(@Valid CreateQuestRequest createQuestRequest, BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/quests");
        }

        UUID playerId = (UUID) session.getAttribute("user_id");
        Player player = playerRepository.findPlayerById(playerId);
        questService.createQuest(createQuestRequest, player);
        return new ModelAndView("redirect:/quests");
    }

    @PatchMapping("/{questId}")
    public String captureQuest(@PathVariable UUID questId, HttpSession session) {

        UUID playerId = (UUID) session.getAttribute("user_id");
        Player player = playerRepository.findPlayerById(playerId);
        Quest quest = questService.findById(questId);

        questService.captureQuest(questId, player);
        return "redirect:/home";
    }

    @ModelAttribute("allQuests")
    public List<?> getAllQuests() {
        return questService.getAllQuests();
    }

    @ModelAttribute("allItems")
    public List<?> getAllItems() {
        return itemService.getAllItems();
    }
}
