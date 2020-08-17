package nl.qien.playground;


import ganzenbord.Speler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);
        model.addAttribute("speler", new Speler());
        return "greeting";
    }

}