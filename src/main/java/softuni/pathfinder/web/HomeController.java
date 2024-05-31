package softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model){
        int sofiaTemp = new Random().nextInt(-10, 45);
        model.addAttribute("sofiaTemperature", sofiaTemp);
//        ModelAndView mnv = new ModelAndView();
//        mnv.setViewName("index");
//        mnv.addObject("sofiaTemperature", sofiaTemp);
        return "index";
    }
}
