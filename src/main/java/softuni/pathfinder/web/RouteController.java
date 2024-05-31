package softuni.pathfinder.web;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.pathfinder.service.RouteService;
import softuni.pathfinder.service.dto.RouteShortDTO;

import java.util.List;

@Controller
public class RouteController {
    private RouteService routeService;
    
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }
    
    @GetMapping("/routes")
    public String routes(Model model){
        //RouteShortDTO randomRoute = routeService.getRandomRoute();
        //model.addAttribute("route", randomRoute);
        List<RouteShortDTO> routes = routeService.getAll();
        model.addAttribute("allRoutes", routes);
        return "routes";
    }
}
