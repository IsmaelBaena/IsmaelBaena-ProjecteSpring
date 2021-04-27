package cat.itb.projectespring.controlador;

import cat.itb.projectespring.model.Usuari;
import cat.itb.projectespring.servei.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Controlador {

    @Autowired
    private UserService servei;

    @GetMapping("/")
    public  String init(){
        return "home";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("usuari", new Usuari());
        return "register";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("usuari") Usuari e){
        e.setRol("USER");
        servei.add(e);
        return "redirect:/list";
    }
}




