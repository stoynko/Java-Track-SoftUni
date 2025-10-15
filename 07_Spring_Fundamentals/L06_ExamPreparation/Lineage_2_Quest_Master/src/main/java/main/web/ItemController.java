package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.Player;
import main.service.ItemService;
import main.service.PlayerService;
import main.web.dto.CreateItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class ItemController {

    private final ItemService itemService;
    private final PlayerService playerService;

    @Autowired
    public ItemController(ItemService itemService, PlayerService playerService) {
        this.itemService = itemService;
        this.playerService = playerService;
    }

    @GetMapping("/items")
    public ModelAndView getItemsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("createItemRequest", new CreateItemRequest());
        modelAndView.setViewName("items");
        return modelAndView;
    }

    @PostMapping("/items")
    public ModelAndView createNewItem(@Valid CreateItemRequest createItemRequest,
                                      BindingResult bindingResult,
                                      HttpSession session) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("redirect:/items");
        }

        UUID playerId = (UUID) session.getAttribute("user_id");
        Player player = playerService.getById(playerId);
        itemService.createNewItem(createItemRequest, player);
        return new ModelAndView("redirect:/items");
    }

    @ModelAttribute("allItems")
    public List<?> allItems() {
        return itemService.getAllItems();
    }
}
