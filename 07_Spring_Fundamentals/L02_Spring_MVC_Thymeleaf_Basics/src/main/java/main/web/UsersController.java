package main.web;

import main.model.*;
import main.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
@RequestMapping("/users")
public class UsersController {


    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ModelAndView getUserDetails(@PathVariable long id) {

        User user = userService.getUserById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-details");


        return modelAndView;
    }
}
