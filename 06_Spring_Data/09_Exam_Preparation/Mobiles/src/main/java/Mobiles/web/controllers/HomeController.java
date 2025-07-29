package Mobiles.web.controllers;

import Mobiles.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

    private final DeviceService deviceService;
    private final SaleService saleService;
    private final SellerService sellerService;

    @Autowired
    public HomeController(DeviceService deviceService, SaleService saleService, SellerService sellerService) {
        this.deviceService = deviceService;
        this.saleService = saleService;
        this.sellerService = sellerService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        boolean areImported = this.deviceService.areImported() &&
                this.sellerService.areImported() &&
                this.deviceService.areImported()  &&
                this.saleService.areImported();

        return super.view("index", "areImported", areImported);
    }
}
