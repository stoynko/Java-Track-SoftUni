package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.Player;
import main.model.PlayerRole;
import main.service.PlayerService;
import main.web.dto.LoginRequest;
import main.web.dto.RegisterRequest;
import main.web.resolver.HomeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class IndexController {

    private final PlayerService playerService;
    private final List<HomeResolver> homeResolvers;

    @Autowired
    public IndexController(PlayerService playerService, List<HomeResolver> homeResolvers) {
        this.playerService = playerService;
        this.homeResolvers = homeResolvers;
    }

    @GetMapping
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/register")
    public ModelAndView getRegistrationPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        modelAndView.addObject("registerRequest", new RegisterRequest());

        return modelAndView;
    }
    @PostMapping("/register")
    public ModelAndView register(@Valid RegisterRequest registerRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }

        playerService.registerUser(registerRequest);

        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("loginRequest", new LoginRequest());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@Valid LoginRequest loginRequest, HttpSession session) {
        Player player = playerService.login(loginRequest);
        session.setAttribute("user_id", player.getId());
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/home")
    public ModelAndView getHomePage(HttpSession session) {

        UUID playerId = (UUID) session.getAttribute("user_id");
        Player player = playerService.getById(playerId);

        HomeResolver homeResolver = homeResolvers.stream().filter(resolver -> resolver.supports(player.getRole())).findFirst().get();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(homeResolver.getViewName());
        modelAndView.addAllObjects(homeResolver.getModelData(player));

        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @ModelAttribute("player")
    public Player getPlayer(HttpSession session) {
        UUID playerId = (UUID) session.getAttribute("user_id");
        return playerService.getById(playerId);
    }
}

