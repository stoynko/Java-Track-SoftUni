package Volcano.web.controllers;

import Volcano.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

    private final VolcanoService volcanoService;
    private final VolcanologistService volcanologistService;
    private final CountryService countryService;

    @Autowired
    public HomeController(VolcanoService volcanoService, VolcanologistService volcanologistService, CountryService countryService) {
        this.volcanoService = volcanoService;
        this.volcanologistService = volcanologistService;
        this.countryService = countryService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        boolean areImported = this.volcanoService.areImported() &&
                this.countryService.areImported() &&
                this.volcanoService.areImported()  &&
                this.volcanologistService.areImported();

        return super.view("index", "areImported", areImported);
    }
}
