package cat.itb.projectespring.controlador;

import cat.itb.projectespring.model.Criminal;
import cat.itb.projectespring.servei.CriminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorCriminal {

    private String nom;

    @Autowired
    private CriminalService criminalService;

    @RequestMapping( value ="/delete/{name}", method = RequestMethod.POST)
    public String removeCriminal(@PathVariable("name") String criminal){
        criminalService.removeByNombre(criminal);
        return "redirect:/";
    }

    @RequestMapping("/lista")
    public String listCriminal(Model m) {
        m.addAttribute("llistarCriminal", criminalService.llistat());
        m.addAttribute("Criminal",new Criminal());
        return "listaCriminal";
    }

    @RequestMapping("/listaOrdenada")
    public String orderedListCriminal(Model m) {
        m.addAttribute("llistarCriminal", criminalService.sortById());
        m.addAttribute("Criminal",new Criminal());
        return "listaCriminal";
    }

    @RequestMapping("/afegir")
    public String addCriminalView(Model model) {
        model.addAttribute("Criminal", new Criminal());
        return "afegirCriminal";
    }

    @PostMapping("/afegirCriminal")
    public String addCriminal(@ModelAttribute("Criminal") Criminal e){
        criminalService.add(e);

        return "redirect:/lista";
    }

    @RequestMapping( value ="/update/{name}", method = RequestMethod.POST)
    public String updateCriminalView(@PathVariable("name") String criminal, Model m){
        nom = criminal;
        m.addAttribute("Criminal", criminalService.searchByNombre(criminal));
        return "updateCriminal";
    }

    @PostMapping("/updateCriminal")
    public String updateCriminal(@ModelAttribute("Criminal") Criminal c) {
        criminalService.updateCriminal(c, nom);
        return "redirect:/lista";
    }
}
