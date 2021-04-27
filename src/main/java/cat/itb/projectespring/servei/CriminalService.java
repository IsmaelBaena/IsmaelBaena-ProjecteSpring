package cat.itb.projectespring.servei;

import cat.itb.projectespring.model.Criminal;
import cat.itb.projectespring.repositori.RepositoriCriminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class CriminalService {

    @Autowired
    private RepositoriCriminal repo;

    public void add(Criminal e) {
        repo.save(e);
    }

    public List<Criminal> llistat() {
        List<Criminal> l = new ArrayList<>();
        repo.findAll().forEach(l::add);
        return l;
    }

    public List<Criminal> sortById() {
        List<Criminal> l = new ArrayList<>();
        repo.findAll().forEach(l::add);
        l.sort(Comparator.comparingLong(Criminal::getId));
        return l;
    }

    @PostConstruct
    public void init() {
        repo.save(new Criminal(2, "Montse", "Madridejos", "Poner ejrcicios dificiles :("));
        repo.save(new Criminal(1, "Pau", "Garrido", "Ser bobo"));
        repo.save(new Criminal(3, "Roger", "Larios", "Robo de flow"));
        repo.save(new Criminal(6, "Saadron", "Martines", "Comer sapos"));
        repo.save(new Criminal(4, "Eric", "Bor-jabón", "Ser rancio jugando al lol"));
    }


    public Criminal searchByNombre(String s) {
        return repo.findById(s).orElse(null);
    }

    public void removeByNombre(String s){
        repo.delete(searchByNombre(s));
    }

    public void updateCriminal(Criminal e, String nombre ) {
        e.setNombre(nombre);
        add(e);
    }
}
